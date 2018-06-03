public class main {

    public int minPatches(int nums[], int n) {

        int x = nums[nums.length-1];

        return x;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,8};
        main m = new main();

        System.out.println(m.minPatches(nums, 5));

    }
}
