package org.kaliy.dailycodingproblem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.kaliy.dailycodingproblem.NodeSerialization.Node;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NodeSerializationTest {

    @ParameterizedTest(name = "serializes node with {2}")
    @MethodSource("testCases")
    void serializesNode(String serializedNode, Node deserializedNode, String caseName) {
        assertThat(deserializedNode.serialize()).isEqualTo(serializedNode);
    }

    @ParameterizedTest(name = "deserializes node with {2}")
    @MethodSource("testCases")
    void deserializesNode(String serializedNode, Node deserializedNode, String caseName) {
        assertThat(Node.from(serializedNode)).isEqualToComparingFieldByFieldRecursively(deserializedNode);
    }

    // test case from the assignment
    @Test
    void serializesAndDeserializesNode() {
        var node = new Node("root", new Node("left", new Node("left.left"), null), new Node("right"));
        assertThat(Node.from(node.serialize()).getLeft().getLeft().getVal()).isEqualTo("left.left");
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("666\t\t", new Node("666", null, null), "no children"),
                Arguments.of("666\t10\t\t\t40\t\t", new Node("666", new Node("10"), new Node("40")), "values in children"),
                Arguments.of("666\t10\t11\t\t\t12\t\t\t40\t41\t\t\t42\t\t", new Node(
                        "666",
                        new Node("10", new Node("11"), new Node("12")),
                        new Node("40", new Node("41"), new Node("42"))
                ), "grandchildren"),
                Arguments.of("666\t\t40\t\t42\t\t", new Node(
                        "666",
                        null,
                        new Node("40", null, new Node("42"))
                ), "only right children"),
                Arguments.of("666\t10\t11\t\t\t\t", new Node(
                        "666",
                        new Node("10", new Node("11"), null),
                        null
                ), "only left children"),
                Arguments.of("666\t10\t11\t111\t\t\t112\t\t\t12\t121\t\t\t122\t\t\t40\t41\t411\t\t\t412\t\t\t42\t421\t\t\t422\t\t", new Node(
                        "666",
                        new Node(
                                "10",
                                new Node("11", new Node("111"), new Node("112")),
                                new Node("12", new Node("121"), new Node("122"))
                        ),
                        new Node(
                                "40",
                                new Node("41", new Node("411"), new Node("412")),
                                new Node("42", new Node("421"), new Node("422"))
                        )
                ), "great-grandchildren"));
    }
}
