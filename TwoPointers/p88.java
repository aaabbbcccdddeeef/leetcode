public class p88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) {
            return;
        }
        // fill from back!
        int p = m + n;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] <= nums2[n]) {
                nums1[--p] = nums2[n--];
            } else {
                nums1[--p] = nums1[m--];
            }
        }
        while (n > 0) {
            nums1[--p] = nums2[n--];
        }
    }
}
