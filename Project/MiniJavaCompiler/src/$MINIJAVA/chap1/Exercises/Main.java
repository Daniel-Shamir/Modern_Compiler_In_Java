package $MINIJAVA.chap1.Exercises;

public class Main {
    public static void main(String[] args) {
        test1();
        System.out.println();
        test2();
        System.out.println();
        test3();

        // NOTE(daniel):
        // for exercise d: I think red-black tree or AVL trees should be enough. I'm not sure though...
    }

    public static void test1() {
        System.out.println("Test1: ");

        // NOTE(daniel): using the functional "insert" here
        Tree t1 = new Tree(null, "c", Integer.valueOf(3), null);
        Tree t2 = t1.insert("b", Integer.valueOf(2), t1);
        Tree t3 = t1.insert("d", Integer.valueOf(4), t2);
        Tree t4 = t1.insert("a", Integer.valueOf(1), t3);
        Tree t5 = t1.insert("e", Integer.valueOf(5), t4);

        System.out.println("t5: " + t5);

        System.out.println("is a in t5? " + t5.member("a"));
        System.out.println("lookup a in t5: " + t5.lookup("a"));

        System.out.println("is x in t5? " + t5.member("x") );
        System.out.println("lookup x in t5: " + t5.lookup("x"));
    }

    public static void test2() {
        System.out.println("Test2: ");

        Tree t1 = new Tree(null, "t", null, null);
        t1 = t1.insert("s").insert("p").insert("i").insert("p").insert("f").insert("b").insert("s").insert("t");
        System.out.println("t1: " + t1);

        Tree t2 = new Tree(null, "a", null, null);
        t2 = t2.insert("b").insert("c").insert("d").insert("e").insert("f").insert("g").insert("h").insert("i");
        System.out.println("t2: " + t2);
    }

    public static void test3() {
        System.out.println("Test3: ");

        // NOTE(daniel): using the object oriented "insert" here
        Tree t1 = new Tree.EmptyTree();
        t1.insert("c", Integer.valueOf(3));
        t1.insert("b", Integer.valueOf(2));
        t1.insert("d", Integer.valueOf(4));
        t1.insert("a", Integer.valueOf(1));
        t1.insert("e", Integer.valueOf(5));
        System.out.println("t1: " + t1);
    }
}
