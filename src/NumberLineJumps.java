public class NumberLineJumps {

    /*The Kangaroos
        x1<x2 starting point
        SPEED=DISTANCE/TIME but here time is jumps so
        SPEED=DISTANCE/JUMPS
        as we are searching at which distance both Kangaroos meet
        we need to find that distance:
        DISTANCE=SPEED*JUMPS here the speed is how many places takes each Kangaroo
        on each jump, this is v1 and v2 for each Kangaroo
        DISTANCE = v1 * j    and     DISTANCE = v2 * j
        we ADD the starting point to each
        Total DISTANCE = (v1 * j)+x1  EQUALS to Total DISTANCE = (v2 * j)+x2
        Now we match the two equations:
        x1 + (v1 * j) = x2 + (v2 * j)
        x1 - x2 = (v2 * j) - (v1 * j)
        x1 - x2 = j * (v2 - v1)
        j = (x1 - x2) / (v2 - v1) this is the point in which they meet, but as we
        are dealing with Integer values, if we get a decimal value they don't meet
        so that there WILL be an VALID number of JUMPS (j) only if the module is ZERO

        (x1 - x2) % (v2 - v1) == 0

     */

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // Write your code here
        if(v2>=v1)
            return "NO";

        if((x1 - x2) % (v2 - v1) == 0){
            return "YES";
        }else{
            return "NO";
        }

    }

}
