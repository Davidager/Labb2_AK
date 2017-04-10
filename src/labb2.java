import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by David on 09-Apr-17.
 */
public class labb2 {

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        //BufferedReader stdin = new BufferedReader(new FileReader("C:\\Users\\David\\IdeaProjects\\Labb2_AK\\src\\testfile.txt"));

        int numVertices = Integer.parseInt(stdin.readLine());  //antal roller
        int numEdges = Integer.parseInt(stdin.readLine());   // antal scener
        int maxColors = Integer.parseInt(stdin.readLine());  // antal skådespelare

        ArrayList<Integer> inEdgeList = new ArrayList<Integer>();
        Integer myInt;
        String[] splittedString;
        String[] stringList = new String[numEdges];
        for (int i = 0; i < numEdges; i++) {
            // räknar med mellanslag mellan hörnen
            stringList[i] = stdin.readLine();
            splittedString = stringList[i].split(" ");
            for (int j = 0; j < 2; j++) {
                myInt = Integer.parseInt(splittedString[j]);
                if (!inEdgeList.contains(myInt)) {
                    inEdgeList.add(myInt);
                }
            }
        }

        if (maxColors > numVertices) {
            maxColors = numVertices;
        }

        System.out.println(numVertices + 3);
        System.out.println(numEdges + 2 + numVertices - inEdgeList.size());
        System.out.println(maxColors + 3);


        StringBuilder sb = new StringBuilder();
        sb.append(maxColors );
        for (int i = 0; i < maxColors; i++) {
            sb.append(" ");
            sb.append(i + 1 + 3);   // +3 för att de första 3 skådespelarna är tagna för att lösa divaproblemet med mera.
        }

        String rolesString = sb.toString();
        for (int i = 0; i < numVertices; i++) {
            System.out.println(rolesString);
        }

        // för att fixa divorna
        System.out.println("1 1");
        System.out.println("1 2");
        System.out.println("1 3");



        // för att fixa divorna
        System.out.println("2 " + (numVertices + 1) + " " + (numVertices + 3));
        System.out.println("2 " + (numVertices + 2) + " " + (numVertices + 3));


        sb = new StringBuilder("2");

        for (int i = 0; i < numEdges; i++) {
            sb.append(" ");
            sb.append(stringList[i]);
            System.out.println(sb.toString());
            sb.setLength(0);
            sb.append("2");
        }
        for (int i = 1; i < numVertices +1; i++) {
            if (!inEdgeList.contains(i)) {
                System.out.println("2 " + i + " " + (numVertices + 3));
            }
        }


    }
}
