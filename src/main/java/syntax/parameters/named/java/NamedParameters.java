package syntax.parameters.named.java;

import java.awt.Color;

public class NamedParameters {

    public static void main(String[] args) {
        Shape shape = Shape.builder()
                .setColor(Color.black)
                .setName("Circle")
                .setSize(42)
                .build();
        System.out.println(shape);
    }

}
