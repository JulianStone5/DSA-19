public class FirstFailingVersion {

    public static long firstBadVersion(long n, IsFailingVersion isBadVersion) {
        long current = n/2;
        long left = 0;
        long right = n;
        while(current > 0 && isBadVersion.isFailingVersion(current) == isBadVersion.isFailingVersion(current-1)) {
            if(isBadVersion.isFailingVersion(current)) {
                right = current;
            } else {
                left = current;
            }
            current = (left+right)/2;
        }
        return current;
    }
}
