package algorithm.collection.common.datastruct.tree;

import java.util.Random;

public class BinaryTreeGeneratorTest {

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        Random random = new Random();
        for (int i=0;i<10000;i++){
            int depth = random.nextInt(10);
            TreeNode root = BinaryTreeGenerator.generateBinaryTree(depth, 10);
            int expectVal = BinaryTreeGenerator.getBinaryTreeDepthByBfs(root);
            if(depth != expectVal){
                System.out.println("测试用例不通过");
                break;
            }
        }
        System.out.println("测试用例通过");
    }

}