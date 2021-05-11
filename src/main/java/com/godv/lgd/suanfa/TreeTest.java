package com.godv.lgd.suanfa;

import lombok.Data;

public class TreeTest {

    @Data
    private class TreeNode<T>{
        private TreeNode leftNode;
        private TreeNode rightNode;
        private T value;

        public TreeNode(T value) {
            this.value = value;
        }
    }

    private class BasicTree<T>{

        private TreeNode rootNode;

        public BasicTree() {
            this.rootNode = null;
        }

        void add(T object){
            if(rootNode==null) {
//                rootNode= new TreeNode<T>();
                return;
            }

            if(object.hashCode()>rootNode.hashCode())rootNode.leftNode=new TreeNode(object);
            rootNode.rightNode=new TreeNode(object);
        }

    }
}
