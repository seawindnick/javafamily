package com.java.study.offer.link;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CopyLink {

    public static void main(String[] args) {

        ComplexListNode complexListNodeA = new ComplexListNode(1);
        ComplexListNode complexListNodeB = new ComplexListNode(2);
        ComplexListNode complexListNodeC = new ComplexListNode(3);
        ComplexListNode complexListNodeD = new ComplexListNode(4);
        ComplexListNode complexListNodeE = new ComplexListNode(5);


        complexListNodeA.setNext(complexListNodeB);
        complexListNodeB.setNext(complexListNodeC);
        complexListNodeC.setNext(complexListNodeD);
        complexListNodeD.setNext(complexListNodeE);

        complexListNodeA.setSibling(complexListNodeC);
        complexListNodeB.setSibling(complexListNodeE);
        complexListNodeD.setSibling(complexListNodeB);

//        ComplexListNode newComplexListNode = copy(complexListNodeA);

//        ComplexListNode newComplexListNode = copy2(complexListNodeA);

        ComplexListNode newComplexListNode = copy3(complexListNodeA);

        while (newComplexListNode != null) {
            System.out.println(newComplexListNode.value);

            if (Objects.nonNull(newComplexListNode.next)) {
                System.out.println(newComplexListNode.next.value);
            }


            if (Objects.nonNull(newComplexListNode.sibling)) {
                System.out.println(newComplexListNode.sibling.value);
            }


            newComplexListNode = newComplexListNode.next;
            System.out.println("----------------");
        }


    }

    private static ComplexListNode copy3(ComplexListNode node) {
        if (Objects.isNull(node)) {
            return null;
        }

        appendNode(node);
        fullSibling(node);
        ComplexListNode targetNode = buildTargetNode(node);
        return targetNode;
    }

    private static ComplexListNode buildTargetNode(ComplexListNode node) {
        ComplexListNode targetNode = null;
        ComplexListNode preNode = null;
        int count = 1;
        while (node != null) {
            ComplexListNode tempNode = node.next;
            if ((count & 1) == 0) {
                if (targetNode == null) {
                    targetNode = node;
                } else {
                    preNode.setNext(node);
                }
                preNode = node;
            }else {
                node.setNext(node.next.next);
            }
            node = tempNode;
            count++;
        }
        return targetNode;
    }

    private static void fullSibling(ComplexListNode node) {
        while (node != null) {
            if (node.sibling != null) {
                ComplexListNode newComplexListNode = node.next;

                ComplexListNode siblingNode = node.sibling;
                newComplexListNode.setSibling(siblingNode.next);
            }
            node = node.next.next;
        }
    }

    private static void appendNode(ComplexListNode node) {
        while (node != null) {
            ComplexListNode complexListNode = new ComplexListNode(node.value);
            ComplexListNode nextNode = node.next;

            complexListNode.setNext(nextNode);
            node.setNext(complexListNode);

            node = nextNode;
        }
    }
//
//    private static ComplexListNode copy2(ComplexListNode node) {
//        if (Objects.isNull(node)) {
//            return null;
//        }
//        Map<ComplexListNode, ComplexListNode> map = new HashMap<>();
//        ComplexListNode targetComplexListNode = buildNode(node, map);
//        fullSibling(node, targetComplexListNode, map);
//        return targetComplexListNode;
//    }
//
//    private static void fullSibling(ComplexListNode node, ComplexListNode targetComplexListNode, Map<ComplexListNode, ComplexListNode> map) {
//        ComplexListNode siblingNode = node;
//        ComplexListNode newFullSiblingNode = targetComplexListNode;
//        while (siblingNode != null) {
//            if (siblingNode.sibling != null) {
//                ComplexListNode tempSiblingNode = map.get(siblingNode.sibling);
//                newFullSiblingNode.setSibling(tempSiblingNode);
//            }
//            siblingNode = siblingNode.next;
//
//            newFullSiblingNode = newFullSiblingNode.next;
//        }
//    }
//
//    private static ComplexListNode buildNode(ComplexListNode node, Map<ComplexListNode, ComplexListNode> map) {
//        ComplexListNode targetComplexListNode = null;
//        ComplexListNode preComplexListNode = null;
//        ComplexListNode startNode = node;
//
//        while (startNode != null) {
//            ComplexListNode tempComplexListNode = new ComplexListNode(startNode.value);
//            if (targetComplexListNode == null) {
//                targetComplexListNode = tempComplexListNode;
//            } else {
//                preComplexListNode.setNext(tempComplexListNode);
//            }
//
//            map.put(startNode, tempComplexListNode);
//            preComplexListNode = tempComplexListNode;
//            startNode = startNode.next;
//        }
//        return targetComplexListNode;
//    }

//    private static ComplexListNode copy(ComplexListNode node) {
//        if (node == null) {
//            return null;
//        }
//        ComplexListNode newComplexListNode = buildNode(node);
//        fullSibling(node, newComplexListNode);
//        return newComplexListNode;
//    }
//
//    private static void fullSibling(ComplexListNode node, ComplexListNode newComplexListNode) {
//        ComplexListNode siblingNode = node;
//        ComplexListNode newFullSiblingNode = newComplexListNode;
//        while (siblingNode != null && newFullSiblingNode != null) {
//            if (siblingNode.sibling != null) {
//                ComplexListNode newSiblingNode = findNewSiblingNode(node, siblingNode.sibling, newComplexListNode);
//                newFullSiblingNode.setSibling(newSiblingNode);
//            }
//            siblingNode = siblingNode.next;
//            newFullSiblingNode = newFullSiblingNode.next;
//        }
//    }
//
//    private static ComplexListNode buildNode(ComplexListNode node) {
//        ComplexListNode newComplexListNode = null;
//        ComplexListNode preNode = null;
//        ComplexListNode searchNode = node;
//        while (searchNode != null) {
//            ComplexListNode complexListNode = new ComplexListNode(searchNode.getValue());
//            if (newComplexListNode == null) {
//                newComplexListNode = complexListNode;
//            } else {
//                preNode.setNext(complexListNode);
//            }
//            preNode = complexListNode;
//            searchNode = searchNode.next;
//        }
//        return newComplexListNode;
//    }
//
//    private static ComplexListNode findNewSiblingNode(ComplexListNode node, ComplexListNode sibling, ComplexListNode newComplexListNode) {
//        while (node != null) {
//            if (Objects.equals(node, sibling)) {
//                return newComplexListNode;
//            }
//            node = node.next;
//            newComplexListNode = newComplexListNode.next;
//        }
//        return null;
//    }


    @Data
    public static class ComplexListNode {
        private int value;
        private ComplexListNode next;
        private ComplexListNode sibling;

        public ComplexListNode(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (!(o instanceof ComplexListNode)) {
                return false;
            }

            ComplexListNode that = (ComplexListNode) o;

            return getValue() == that.getValue();

        }

        @Override
        public int hashCode() {
            return getValue();
        }
    }
}
