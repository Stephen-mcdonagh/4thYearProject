package com.passport.Application.models;

public class Face {

        //Gettes and Setters for Face

        private int xC0ordinate;
        private int yCoordinate;
        private int width;
        private int height;
        private double ratio;

        public Face(int x, int y, int width, int height, double ratio) {
            this.xC0ordinate = x;
            this.yCoordinate = y;
            this.width = width;
            this.height = height;
            this.ratio = ratio;
        }

        public int getX() {
            return xC0ordinate;
        }

        public void setX(int x) {
            this.xC0ordinate = x;
        }

        public int getY() {
            return yCoordinate;
        }

        public void setY(int y) {
            this.yCoordinate = y;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public double getRatio() {
            return ratio;
        }

        public void setRatio(float ratio) {
            this.ratio = ratio;
        }
}
