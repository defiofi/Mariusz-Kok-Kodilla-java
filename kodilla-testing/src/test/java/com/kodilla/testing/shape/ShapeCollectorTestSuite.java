package com.kodilla.testing.shape;

import com.kodilla.testing.shape.ShapeCollector;
import com.kodilla.testing.shape.Shape;
import com.kodilla.testing.shape.Square;
import com.kodilla.testing.shape.Circle;
import com.kodilla.testing.shape.Triangle;
import org.junit.jupiter.api.*;

@DisplayName("ShapeCollector class check")
public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }
    @Nested
    @DisplayName("Testy dodania figury")
    class AddFigure {
        @DisplayName("Test dodania figury przy pustej kolekcji")
        @Test
        void testAddFirstFigure() {
            //Given
            ShapeCollector test = new ShapeCollector();
            Circle aCircle = new Circle();

            //When
            int before = test.getListLength();
            test.addFigure(aCircle);

            //Then
            Assertions.assertTrue((before+1) == test.getListLength());
            Assertions.assertEquals(aCircle , test.getFigure(0));
        }
        @DisplayName("Test dodania kazdej z figur do kolekcji")
        @Test
        void testAddNextFigure() {
            //Given
            ShapeCollector test = new ShapeCollector();
            Circle aCircle = new Circle();
            Square aSquere = new Square();
            Triangle aTriangle = new Triangle();

            //When
            int before = test.getListLength();
            test.addFigure(aTriangle);
            test.addFigure(aSquere);
            test.addFigure(aCircle);

            //Then
            Assertions.assertTrue((before+3) == test.getListLength());
            Assertions.assertEquals(aTriangle,test.getFigure(0));
            Assertions.assertEquals(aSquere,test.getFigure(1));
            Assertions.assertEquals(aCircle,test.getFigure(2));
        }
    }
    @Nested
    @DisplayName("Testy usuwania figur")
    class RemoveFigure {
        @DisplayName("Test usuniecia figury gdy kolekcja pusta")
        @Test
        void testRemoveFigureEmptyColection() {
            //Given
            ShapeCollector test = new ShapeCollector();
            Circle aCircle = new Circle();

            //When
            boolean result = test.removeFigure(aCircle);

            //Then
            Assertions.assertFalse(result);
            Assertions.assertTrue(test.getListLength() == 0);
        }
        @DisplayName("Test usuniecia figury gdy kolekcja zawiera figury")
        @Test
        void testRemoveFigureFromColection() {
            //Given
            ShapeCollector test = new ShapeCollector();
            Circle aCircle = new Circle();
            Square aSquere = new Square();
            Triangle aTriangle = new Triangle();

            //When
            test.addFigure(aTriangle);
            test.addFigure(aSquere);
            test.addFigure(aCircle);
            int before = test.getListLength();

            //Then
            boolean result = test.removeFigure(aCircle);
            Assertions.assertTrue(result);
            Assertions.assertTrue((before - 1) == test.getListLength());
        }
    }
    @Nested
    @DisplayName("Testy pobierania figur")
    class GetFigure {
        @DisplayName("Test pobrania figury gdy kolekcja pusta")
        @Test
        void testgetFigureEmptyCollection() {
            //Given
            ShapeCollector test = new ShapeCollector();
            //When
            Shape result = test.getFigure(0);
            //Then
            Assertions.assertTrue(result == null );
        }
        @DisplayName("Test pobrania figury z ujemnym indeksem")
        @Test
        void testgetFigureNegativeIndex(){
            //Given
            ShapeCollector test = new ShapeCollector();
            Circle aCircle = new Circle();

            //When
            test.addFigure(aCircle);
            Shape result = test.getFigure(-1);

            //Then
            Assertions.assertTrue(result == null );
        }
        @DisplayName("Test pobrania figury z kolekcji zawierajacej kazda z figur")
        @Test
        void testgetFigure() {
            //Given
            ShapeCollector test = new ShapeCollector();
            Circle aCircle = new Circle();
            Square aSquere = new Square();
            Triangle aTriangle = new Triangle();

            //When
            test.addFigure(aTriangle);
            test.addFigure(aSquere);
            test.addFigure(aCircle);

            //Then
            Assertions.assertEquals(aTriangle,test.getFigure(0));
            Assertions.assertEquals(aSquere,test.getFigure(1));
            Assertions.assertEquals(aCircle,test.getFigure(2));
        }
        @DisplayName("Test pobrania figury z kolekcji gdy indeks jest za duzy")
        @Test
        void testgetFigureTooLargeIndex() {
            //Given
            ShapeCollector test = new ShapeCollector();
            Circle aCircle = new Circle();
            Square aSquere = new Square();
            Triangle aTriangle = new Triangle();

            //When
            test.addFigure(aTriangle);
            test.addFigure(aSquere);
            test.addFigure(aCircle);

            //Then
            Assertions.assertTrue(test.getFigure(5) == null);
        }
    }
    @Nested
    @DisplayName("Testy pokazania wszystkich figur w kolekcji")
    class ShowFigures {
        @DisplayName("Test pokazania wszystkich figur gdy kolekcja pusta")
        @Test
        void testshowFiguresEmptyColection() {
            //Given
            ShapeCollector test = new ShapeCollector();

            //When
            String result = test.showFigures();

            //Then
            Assertions.assertTrue(result == null || result.length() == 0);
        }
        @DisplayName("Test pokazania wszystkich figur gdy kolekcja zawiera figury")
        @Test
        void testshowFigures() {
            //Given
            ShapeCollector test = new ShapeCollector();
            Circle aCircle = new Circle();
            Square aSquere = new Square();
            Triangle aTriangle = new Triangle();

            //When
            test.addFigure(aTriangle);
            test.addFigure(aSquere);
            test.addFigure(aCircle);
            String patern = aTriangle.getShapeName()+" "+aSquere.getShapeName()+" "+aCircle.getShapeName();

            //Then
            String result = test.showFigures();
            Assertions.assertEquals(patern , result);
        }
    }
}
