import org.w3c.dom.Node;

import javax.swing.tree.TreeNode;

public class Main {
    public static void main(String[] args) {
        //[-10,-5,-3,0,5,8,9]  example list
        /*
                     0
                   /   \
                 -5      8
                / \     / \
              -10 -3   5   9

              the goal is to split the tree repeatedly into smaller subtrees through defining new boundaries and a new mid
              eventually, on final recursive call, l == r and also == mid via bringing the right barrier towarrds lefft
              or left barrrir towarrds right depending on .right or .left recursivee call.
              on base casee call, null reeturnrd sincee leaf node will point to null for both its .left and .right recursive calls
              we then pop off the call stack back up.

              the sequence will be like this:
              - 0 defined as mid. 0 on call stack. .left called
              - -5 defined as mid. -5 on call stack. left called
              - -10 dfind as mid. -10 on call stack. left called --> null. right called --> null, -10 popped off stack
              - -5 .right called
              - -3 defiend as mid. -3 on call stack. left and right called --> null. -3 popped off
              - -5 popped off
              - 0 .right called, etc.

         */
    }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return CreateBST(nums, 0, nums.length - 1);
    }
    private TreeNode CreateBST(int nums[], int l, int r) {
        if (l > r) { // Base
            return null;
        }

        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = CreateBST(nums, l, mid - 1);
        root.right = CreateBST(nums, mid + 1, r);
        return root;
    }
}


//NOPE. OF COURSE ITS A RECURRSIVE SOLUTION
//class Solution {
//    public TreeNode sortedArrayToBST(int[] nums) {
//        int middle = (nums.length-1)/2;
//        TreeNode temp = null;
//        for(int i = 0; i< middle; i++){
//            new TreeNode(nums[i]).right = temp; // idea of calling construtor with value only
//
//        }
//        new TreeNode root = nums[middle];
//        root.left = temp;
//
//        for(int i = middle; i<nums.length-1; i++){
//            temp = nums[i+1];
//            nums[i].right = temp;
//        }
//        return root;
//    }
//}

// int root = (nums.length-1)/2
// temp = null;

// first loop starting index 0  then i<root
//build bottom up saying treenode temp = -3. --> newNode.right = temp
// temp = new node.

// break first loop. say root.left = temp

// second loop starting at root+1 through i<nums.length-1
// build root down, rroot.right = newNode

// this idea just makes the array into a linear version of a binary tree. can't use forr O(log n)
// but i don't see a way this doesn't just result in a line