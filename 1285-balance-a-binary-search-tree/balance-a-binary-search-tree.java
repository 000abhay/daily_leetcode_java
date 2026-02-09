/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

     void fun(List<Integer>arr,TreeNode root)
     {
        if(root==null) return ;

        fun(arr,root.left);
        arr.add(root.val);
        fun(arr,root.right);
        
     }
     TreeNode build(List<Integer>arr,int i,int n)
     {
        if(i>n) return null;
        int mid=i+(n-i)/2;
         TreeNode x =new TreeNode(arr.get(mid));
         x.left=build(arr,i,mid-1);
         x.right=build(arr,mid+1,n);
          return x;
     }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer>arr=new ArrayList<>();
          fun(arr,root);
          int n=arr.size()-1;
        return build(arr,0,n);
    }
}