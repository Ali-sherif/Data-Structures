/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author Ali
 */
class TreeNode<treeEntry> {

    treeEntry entry;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
        left = right = null;
    }

    public TreeNode(treeEntry entry) {
        this();
        this.entry = entry;
    }

}

public class Tree<treeEntry> {

    private int size;
    private TreeNode root;

    public Tree() {
        root = null;
        size = 0;
    }

    public int treeFull() {
        return 0;
    }

    public int treeSize() {
        return size;
    }
  
    public int treeEmpty() {
        return (root == null) ? 1 : 0;
    }
  
    
   // delete node form tree
    private void deleteNodeTree(TreeNode pt, TreeNode parent) {

        TreeNode q = pt, r;
        if (pt.left == null) {
            
            parent.right = pt.right;
            
        } else if (pt.right == null) {
            
            parent.left = pt.left;

        } else {
            
            q = pt.left;
            if (q.right == null) {
                pt.entry = q.entry;
                pt.left = q.left;
            } else {

                do {
                    r = q;
                    q = q.right;
                } while (q.right != null);
                pt.entry = q.entry;
                r.right = q.left;
            }
        }
        q = null;
    }

    public int deleteItemTree(treeEntry e, TreeNode pn) {
        
        int found = 0;
        TreeNode q = root;
        TreeNode r = null;
        if (root.entry == e) {
            pn.entry = q.entry;
            found = 1;
            deleteNodeTree(root, r);
        } else {
            while (q != null && found == 0) {

                if (q.entry == e) {

                    found = 1;
                } else if ((int) q.entry > (int) e) {
                    r = q;
                    q = q.left;
                } else {
                    r = q;
                    q = q.right;
                }

            }
            if (found == 1) {
                pn.entry = q.entry;
                if ((int) r.entry > (int) e) {
                    deleteNodeTree(r.left, r);
                } else {
                    deleteNodeTree(r.right, r);
                }
            }
        }
        size--;
        return found;
    }
   
    
    // retrive depth of tree
    private int treeDepthAux(TreeNode pt) {

        if (pt == null) {
            return 0;

        }

        return (1 + Math.max(treeDepthAux(pt.left), treeDepthAux(pt.right)));
    }

    public int treeDepth() {
        if (root == null) {
            return 0;
        }
        /*  int a = treeDepthAux(root.left);
        int b = treeDepthAux(root.right);*/
        return treeDepthAux(root);
        //return (a > b) ? a + 1 : b + 1;
    }

    
   // clear tree
    private void clearTreeRecAux(TreeNode pn) {
        if (pn != null) {
            clearTreeRecAux(pn.left);
            clearTreeRecAux(pn.right);
            pn = null;
        }
    }

    public void clearTreeRec() {
        clearTreeRecAux(root);
        root = null;
        size = 0;
    }

    
    // insert a new node to tree by iterative method
    public void insertTree(treeEntry e) {
        TreeNode pn, prev, current;

        pn = new TreeNode(e);
        if (root == null) {
            root = pn;
        } else {
            current = prev = root;
            while (current != null) {
                prev = current;
                if ((int) current.entry > (int) e) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            if ((int) prev.entry > (int) e) {
                prev.left = pn;
            } else {
                prev.right = pn;
            }

        }

        size++;
    }
    
    
    // insert a new node to tree by recursive method
    private TreeNode insertTreeRecAux(TreeNode pt, treeEntry e) {
        if (pt == null) {
            pt = new TreeNode(e);

        } else if ((int) pt.entry > (int) e) {
            pt.left = insertTreeRecAux(pt.left, e);

        } else {
            pt.right = insertTreeRecAux(pt.right, e);

        }
        return pt;
    }

    public void insertTreeRec(treeEntry e) {
        root = insertTreeRecAux(root, e);
        size++;
    }

    
    // traverse tree inorder L V R
    private void inorderAux(TreeNode pt) { // L V R keep move to most left and back to v and tack right 
        if (pt != null) {
            inorderAux(pt.left);
            System.out.println("value of visited node is  " + pt.entry);
            inorderAux(pt.right);
        }
    }

    public void inorderRec() {
        inorderAux(root);

    }

    
     // find node in tree by iterative method
    public int findItemTree(treeEntry e, TreeNode pt) {
        int found = 0;
        TreeNode pn = root;
        while (pn != null && found == 0) {
            if (pn.entry == e) {
                pt = pn;
                found = 1;
            } else if ((int) pn.entry > (int) e) {
                pn = pn.left;
            } else {
                pn = pn.right;
            }
        }
        return found;

    }

    
    // find node in tree by recursive method
    private int findItemTreeRecAux(TreeNode pt, treeEntry e, TreeNode pn) {
        if (pt == null) {
            return 0;
        }
        if (pt.entry == e) {
            pn.entry = (int) pt.entry;
            return 1;
        } else if ((int) pt.entry > (int) e) {
            return findItemTreeRecAux(pt.left, e, pn);
        } else {
            return findItemTreeRecAux(pt.right, e, pn);
        }

    }

    public int findItemTreeRec(treeEntry e, TreeNode pn) {

        return findItemTreeRecAux(root, e, pn);
    }


}
