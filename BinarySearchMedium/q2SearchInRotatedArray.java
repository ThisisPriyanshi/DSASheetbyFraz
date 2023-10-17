public class q2SearchInRotatedArray {

    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        if (pivot == -1 ) //array is not rotataed
        {
            // just do normal binary search
            return binarySearchCode(nums, target, 0, nums.length-1);
        }

        //if pivot is found we have two ascending sorted arrays
        if (nums[pivot] == target) {
            return pivot;
        }

        if (target >= nums[0])
        {
            return binarySearchCode(nums, target, 0, pivot -1);
        }

        return binarySearchCode(nums, target, pivot +1, nums.length -1);
    }

    public static int binarySearchCode(int[] arr, int target, int start, int end)
    {

        while (start<=end)
        {
            int mid = start + (end - start) /2;
            if (target > arr[mid])
            {
                start = mid +1;
            }
            else if (target < arr[mid])
            {
                end = mid - 1;
            }
            else
            {
                return mid;
            }
        }

        return -1;
    }

    public static int findPivot(int[] arr)
    {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end)
        {
            int mid = start + (end-start) / 2;
            //4 cases
            if ( (mid < end) && (arr[mid] > arr[mid + 1]))//case 1
            {
                return mid;
            }

            if ( (mid> start) && (arr[mid] < arr[mid - 1]))//case 1
            {
                return mid-1;
            }

            if (arr[mid] <= arr[start])
            {
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
