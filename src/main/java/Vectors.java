import java.util.*;
public class Vectors {
    
    public static String intersect_or_union_fcn(int[] v1, int[] v2, int[] v3){
        
         // first search v3 in v1
        boolean isPresentV1 = true;
        for (int num : v3) {
            boolean notPresentV1 = false;
            for (int numv1 : v1) {
                if (num == numv1) {
                    notPresentV1 = true;
                    break;
                }
            }
            if (!notPresentV1) {
                isPresentV1 = false;
                break;
            }
        }
         // second search v3 in v2
        boolean isPresentV2 = true;
        for (int num : v3) {
            boolean notPresentV2 = false;
            for (int numv2 : v2) {
                if (num == numv2) {
                    notPresentV2 = true;
                    break;
                }
            }
            if (!notPresentV2) {
                isPresentV2 = false;
                break;
            }
        }
         // if elements in v3 found in both v1 and v2
        if (isPresentV1 && isPresentV2) return "v3 is the intersection of v1 and v2";

        // when its not an intersection

            int[] union = new int[v1.length+v2.length];
            System.arraycopy(v1,0,union,0,v1.length);
            System.arraycopy(v2,0,union,v1.length,v2.length);
            
            for(int num: v3){
                boolean found = false;
                for(int numUnion: union){
                    if(num==numUnion){
                        found = true;
                        break;
                    }
                }
                if(!found)return "v3 is neither the intersection nor the union of v1 and v2";
            }

        return "v3 is the union of v1 and v2";
    }
  public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Info for v1");
        int v1[] = getVector(input);
        System.out.println("Info for v2");
        int v2[] = getVector(input);
        System.out.println("Info for v3");
        int v3[] = getVector(input);

        System.out.println("" + intersect_or_union_fcn(v1, v2, v3));

    }

    public static int[] getVector(Scanner input) {

        System.out.println("Input number of elements in the vector: ");
        int size = input.nextInt();

        int[] vector = new int[size];
        for (int i = 0; i < size; i++) {

            System.out.println("Enter element #" + (i + 1) + ": ");
            vector[i] = input.nextInt();
        }

        return vector;
    }
    }
        
    
    

