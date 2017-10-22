package syntax.parameters.named.java;

import java.awt.Color;

public class Shape {

    private final int size;
    private final Color color;
    private final String name;

    private Shape(Builder builder) {
        size = builder.size;
        color = builder.color;
        name = builder.name;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int size;
        private Color color;
        private String name;

        public Shape build() {
            return new Shape(this);
        }

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public Builder setColor(Color color) {
            this.color = color;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
    }

}