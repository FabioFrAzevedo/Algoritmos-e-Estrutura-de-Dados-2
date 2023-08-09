import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

class SWCharacter {
    private String name;
    private Integer height;
    private Double mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String homeworld;

    private Integer parseIndex;

    public SWCharacter() {
        this.name = null;
        this.height = null;
        this.mass = null;
        this.hairColor = null;
        this.skinColor = null;
        this.eyeColor = null;
        this.birthYear = null;
        this.gender = null;
        this.homeworld = null;
        this.parseIndex = null;
    }

    public SWCharacter(String path) throws IOException {
        this.parseIndex = 2;
        BufferedReader f = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        String json = f.readLine();

        this.name = this.jsonSubstring(json, "name");
        String height = this.jsonSubstring(json, "height");
        String mass = this.jsonSubstring(json, "mass");
        this.height = height.equals("unknown") ? 0 : Integer.parseInt(height);
        this.mass = mass.equals("unknown") ? 0 : Double.parseDouble(mass.replace(",", ""));
        this.hairColor = this.jsonSubstring(json, "hair_color");
        this.skinColor = this.jsonSubstring(json, "skin_color");
        this.eyeColor = this.jsonSubstring(json, "eye_color");
        this.birthYear = this.jsonSubstring(json, "birth_year");
        this.gender = this.jsonSubstring(json, "gender");
        this.homeworld = this.jsonSubstring(json, "homeworld");

        f.close();
    }

    private String jsonSubstring(String json, String key) {
        int start = this.parseIndex + key.length() + 4;
        this.parseIndex = start;
        while (json.charAt(this.parseIndex) != '\'')
            this.parseIndex++;
        this.parseIndex += 4;
        return json.substring(start, this.parseIndex - 4);
    }

    public SWCharacter clone() {
        SWCharacter clone = new SWCharacter();

        clone.name = this.name;
        clone.height = this.height;
        clone.mass = this.mass;
        clone.hairColor = this.hairColor;
        clone.skinColor = this.skinColor;
        clone.eyeColor = this.eyeColor;
        clone.birthYear = this.birthYear;
        clone.gender = this.gender;
        clone.homeworld = this.homeworld;

        return clone;
    }

    public String toString() {
        String str = " ## ";
        String stringMass = this.mass.toString();

        if (this.mass.intValue() == this.mass)
            stringMass = "" + this.mass.intValue();

        str += this.name + " ## ";
        str += this.height + " ## ";
        str += stringMass + " ## ";
        str += this.hairColor + " ## ";
        str += this.skinColor + " ## ";
        str += this.eyeColor + " ## ";
        str += this.birthYear + " ## ";
        str += this.gender + " ## ";
        str += this.homeworld + " ## ";

        return str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }
}

class Node {
    String name;
    Node left, right;
    int level;

    Node(String name) {
        this(name, null, null, 1);
    }

    Node(String name, Node left, Node right, int level) {
        this.name = name;
        this.left = left;
        this.right = right;
        this.level = level;
    }

    public void setLevel() {
        this.level = 1 + Math.max(getLevel(left), getLevel(right));
    }

    public static int getLevel(Node node) {
        return (node == null) ? 0 : node.level;
    }

}

class BinaryTree {
    Node root;

    // starting the tree with root node Null
    BinaryTree() {
        this.root = null;
    }

    void insertInTheTree(SWCharacter x) throws Exception {
        root = insertName(x.getName(), root);
    }

    Node insertName(String x, Node i) throws Exception {
        if (i == null) {
            i = new Node(x);
        } else if (x.compareTo(i.name) > 0) {
            i.right = insertName(x, i.right);
        } else if (x.compareTo(i.name) < 0) {
            i.left = insertName(x, i.left);
        } else {
            throw new Exception("ERRO!");
        }
        return balance(i);
    }

    Node balance(Node i) throws Exception {
        if (i != null) {
            int factor = Node.getLevel(i.right) - Node.getLevel(i.left);
            if (Math.abs(factor) <= 1) {
                i.setLevel();
            } else if (factor == 2) {
                int rightChildFactor = Node.getLevel(i.right.right) - Node.getLevel(i.right.left);

                if (rightChildFactor == -1) {
                    i.right = rightRotation(i.right);
                }
                i = leftRotation(i);
            } else if (factor == -2) {
                int leftChildFactor = Node.getLevel(i.left.right) - Node.getLevel(i.left.left);
                if (leftChildFactor == 1) {
                    i.left = leftRotation(i.left);
                }
                i = leftRotation(i);
            } else {
                throw new Exception("ERRO!");
            }
        }
        return i;
    }

    private Node leftRotation(Node node) {
        Node nodeRight = node.right;
        Node nodeRightLeft = node.right.left;

        nodeRight.left = node;
        node.right = nodeRightLeft;

        node.setLevel();
        nodeRight.setLevel();

        return nodeRight;
    }

    private Node rightRotation(Node node) {
        Node nodeLeft = node.left;
        Node nodeLeftRight = node.left.right;

        nodeLeft.right = node;
        node.left = nodeLeftRight;

        node.setLevel();
        nodeLeft.setLevel();
        return nodeLeft;
    }

    boolean search(String s) {
        System.out.print(s + " raiz");
        return search(s, root);
    }

    boolean search(String s, Node i) {
        boolean resp;
        if (i == null) {
            resp = false;
        } else if (s.equals(i.name)) {
            resp = true;
        } else if (s.compareTo(i.name) < 0) {
            System.out.print(" esq");
            resp = search(s, i.left);
        } else {
            System.out.print(" dir");
            resp = search(s, i.right);
        }
        return resp;
    }

}

public class Programa {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String str = new String();
        BinaryTree tree = new BinaryTree();

        try {
            while (!(str = br.readLine()).equals("FIM")) {
                tree.insertInTheTree(new SWCharacter(str));
            }
        } catch (IOException e) {
            System.out.println("Erro!");
        }

        while (!(str = br.readLine()).equals("FIM"))
            if (tree.search(str)) {
                System.out.println(" SIM");
            } else
                System.out.println(" NÃO");
    }
}
