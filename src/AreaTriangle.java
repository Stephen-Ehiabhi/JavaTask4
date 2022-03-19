import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class RectangleArea {
    float width;
    float height;
    float area;

    void getData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Area of Rectangle calculator");
        System.out.println("Please type in the width: ");
        width = Float.parseFloat(br.readLine());
        System.out.println("Please type in the height: ");
        height = Float.parseFloat(br.readLine());
    }

    void computeField() {
        area = width * height;
    }

    void fieldDisplay() {
        System.out.println("The area of a rectangle is: " + area);
    }
}


public class AreaTriangle {
    public static void main(String[] args) throws IOException {
        RectangleArea rg = new RectangleArea();
        rg.getData();
        rg.computeField();
        rg.fieldDisplay();
    }
}
