package Graphs.NaryTree;

import java.util.Stack;

public class SectionCount {
    public static void main(String[] args) {
        Node node1 = new Node("1");
        Node node1_1 = new Node("1_1");
        node1.addChild(node1_1);
        Node node1_1_1 = new Node("1_1_1");
        node1_1.addChild(node1_1_1);
        Node node1_1_2 = new Node("1_1_2");
        node1_1.addChild(node1_1_2);
        Node node1_1_2_1 = new Node("1_1_2_1");
        node1_1_2.addChild(node1_1_2_1);
        Node node1_1_3 = new Node("1_1_3");
        node1_1.addChild(node1_1_3);
        Node node1_2 = new Node("1_2");
        node1.addChild(node1_2);

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        dfsAndPrintSection(node1, stack);
    }

    private static void dfsAndPrintSection(Node node, Stack<Integer> stack) {
        String section = formatSection(stack);
        System.out.println("Node " + node.value + " section = " + section);

        for (int i = 0; i < node.children.size(); i++) {
            // create a new level for the first child
            if (i == 0) {
                stack.push(1);

            // increment the value in the same level
            } else {
                stack.push(stack.pop() + 1);
            }

            dfsAndPrintSection(node.children.get(i), stack);

            // retract the level after the last child is visited
            if (i == node.children.size() - 1) {
                stack.pop();
            }
        }
    }

    private static String formatSection(Stack<Integer> stack) {
        StringBuilder sectionBuilder = new StringBuilder();
        for (Integer integer : stack) {
            sectionBuilder.append(integer).append(".");
        }
        String section = sectionBuilder.toString();
        if (section.endsWith(".")) {
            section = section.substring(0, section.length() - 1);
        }
        return section;
    }


}
