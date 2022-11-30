package week1.day06.cube;

public class CubicCutArea {
    public static void main(String[] args) {
        /**
         * initialize variable
         */
        int area = 0;
        String[][][] cube = new String[7][7][7];
        /**
         * Initialize the array first
         */
        for (int row = 0; row < cube.length; row++) {
            for (int cols = 0; cols < cube[row].length; cols++) {
                for (int vertical = 0; vertical < cube[row][cols].length; vertical++) {
                    cube[row][cols][vertical] = "0";
                }
            }
        }
        /**
         * Initialize Cube
         */
        for (int row = 1; row < cube.length - 1; row++) {
            for (int cols = 1; cols < cube[row].length - 1; cols++) {
                for (int vertical = 1; vertical < cube[row][cols].length - 1; vertical++) {
                    cube[row][cols][vertical] = "1";
                }
            }
        }
        /**
         * Digging cube on the front
         */
        for (int cols = 2; cols < 5; cols++) {
            for (int vertical = 1; vertical < cube[3][cols].length - 1; vertical++) {
                if (cube[3][cols][vertical].equals("1")) {
                    cube[3][cols][vertical] = "0";
                }
            }
        }
        for (int row = 2; row < 5; row++) {
            for (int vertical = 1; vertical < cube[row][3].length - 1; vertical++) {
                if (cube[row][3][vertical].equals("1")) {
                    cube[row][3][vertical] = "0";
                }
            }
        }
        /**
         * Cube for chiseling sides
         */
        for (int cols = 2; cols < 5; cols++) {
            for (int row = 1; row < cube.length - 1; row++) {
                if (cube[row][cols][3].equals("1")) {
                    cube[row][cols][3] = "0";
                }
            }
        }
        for (int vertical = 2; vertical < 5; vertical++) {
            for (int row = 1; row < cube.length - 1; row++) {
                if (cube[row][3][vertical].equals("1")) {
                    cube[row][3][vertical] = "0";
                }
            }
        }
        /**
         * Cube above the chisel
         */
        for (int row = 2; row < 5; row++) {
            for (int cols = 1; cols < cube[3].length; cols++) {
                if (cube[row][cols][3].equals("1")) {
                    cube[row][cols][3] = "0";
                }
            }
        }
        for (int vertical = 2; vertical < 5; vertical++) {
            for (int cols = 1; cols < cube[3].length; cols++) {
                if (cube[3][cols][vertical].equals("1")) {
                    cube[3][cols][vertical] = "0";
                }
            }
        }
        /**
         * Judge whether the label of the small cube is 1. If it is 1, continue to judge whether the front, back,
         * left, right, top and bottom are 0. If it is 0, the area increases by 1
         */
        for (int row = 1; row < cube.length - 1; row++) {
            for (int cols = 1; cols < cube[row].length; cols++) {
                for (int vertical = 0; vertical < cube[row][cols].length; vertical++) {
                    if (cube[row][cols][vertical].equals("1")) {
                        if (cube[row + 1][cols][vertical].equals("0")) {
                            area++;
                        }
                        if (cube[row][cols + 1][vertical].equals("0")) {
                            area++;
                        }
                        if (cube[row][cols][vertical + 1].equals("0")) {
                            area++;
                        }
                        if (cube[row - 1][cols][vertical].equals("0")) {
                            area++;
                        }
                        if (cube[row][cols - 1][vertical].equals("0")) {
                            area++;
                        }
                        if (cube[row][cols][vertical - 1].equals("0")) {
                            area++;
                        }
                    }
                }
            }
        }
        System.out.println("挖凿后的立方体面积为：" + area);
    }
}
