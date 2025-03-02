package $MINIJAVA.chap1.Exercises;

public class Tree {
    Tree left, right;
    String key;
    Object binding;
    public Tree(Tree left, String key, Object binding, Tree right) {
        this.left = left;
        this.key = key;
        this.binding = binding;
        this.right = right;
    }

    // NOTE(daniel): in functional style
    public Tree insert(String key, Object binding, Tree t) {
        if(t == null) {
            return new Tree(null, key, binding, null);
        } else if(key.compareTo(t.key) < 0) {
            return new Tree(insert(key, binding, t.left), t.key, t.binding, t.right);
        } else if(key.compareTo(t.key) > 0) {
            return new Tree(t.left, t.key, t.binding, insert(key, binding, t.right));
        } else {
            return new Tree(t.left, key, binding, t.right);
        }
    }

    // NOTE(daniel): in object oriented style
    public void insert(String key, Object binding) {
        if(this.key.compareTo(key) < 0) {
            if(left != null) {
                left.insert(key, binding);
            } else {
                left = new Tree(null, key, binding, null);
            }
        } else if(this.key.compareTo(key) > 0) {
            if(right != null) {
                right.insert(key, binding);
            } else {
                right = new Tree(null, key, binding, null);
            }
        }
        // NOTE(daniel): if key equals our key, do nothing since we are already the correct node
        // this is fine since our binary trees are no longer persistent, calling insert on an object implies
        // we are changing its state
    }

    // NOTE(daniel): this is for convenience
    public Tree insert(String key) {
        return insert(key, null, this);
    }

    public boolean member(String key) {
        if(this.key.equals(key)) {
            return true;
        } else {
            // NOTE(daniel): this is ugly, but the book wanted to do this in a functional way, so can't reassign variables
            if(left != null && right == null) {
                return left.member(key);
            }
            if(left == null && right != null) {
                return right.member(key);
            }
            if(left != null && right != null) {
                return left.member(key) || right.member(key);
            }
        }

        return false;
    }

    public Object lookup(String key) {
        if(this.key.equals(key)) {
            return binding;
        } else {
            if(left != null && right == null) {
                return left.lookup(key);
            }
            if(left == null && right != null) {
                return right.lookup(key);
            }
            if(left != null && right != null) {
                Object ob1 = left.lookup(key);
                Object ob2 = right.lookup(key);
                return ob1 != null ? ob1 : ob2;
            }
        }

        return null;
    }

    public String toString() {
        // NOTE(daniel): prints in infix order
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        if(left != null) {
            sb.append(left);
            sb.append("<-");
        }

        // NOTE(daniel): this just clutters things, so i commented it out
//        sb.append("(");
//        sb.append(key);
//        sb.append(":");
//        sb.append(binding);
//        sb.append(")");

        sb.append(key);

        if(right != null) {
            sb.append("->");
            sb.append(right);
        }

        sb.append("]");

        return sb.toString();
    }

    public static class EmptyTree extends Tree {
        public EmptyTree() {
            super(null, null, null, null);
        }

        public void insert(String key, Object binding) {
            if(this.key == null) {
                this.key = key;
                this.binding = binding;
            } else {
                super.insert(key, binding);
            }
        }
    }
}
