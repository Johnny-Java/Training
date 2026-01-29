package org.training.tasks;

public class ContainerWithMostWater {

    public static void execute(){
        var height = new int[] {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height){
        int maxArea = 0;
        int area;
        int maxRightHeight;
        int maxLeftHeight;

        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            if (height[i] < height[j]) {
                area = height[i] * (j - i);
                if (area > maxArea) maxArea = area;
                maxLeftHeight = height[i];
                do {
                    i++;
                } while (i < j && height[i] < maxLeftHeight);
            } else {
                area = height[j] * (j - i);
                if (area > maxArea) maxArea = area;
                maxRightHeight = height[j];
                do {
                    j--;
                } while (j > i && height[j] < maxRightHeight);
            }
        }

        return maxArea;

    }
}
