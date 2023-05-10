package com.example.ptit.ui.xemdiem;

import com.example.ptit.model.Point;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PointAdapterTest {
    @Test
    public void testTbHK() {
        Point point1 = new Point(3, "INT1434", "Lập trình Web", 3, 10, 20, 20, 0, 50, 8.0F,
                7.0F, 7.0F, 0.0F, 1.0F, 0.0F, 4.1F, "D", "Đạt", 1);
        Point point2 = new Point(3, "INT14148", "Cơ sở dữ liệu phân tán", 3, 10, 10, 0, 20, 60, 9.0F,
                8.3F, 0.0F, 6.2F, 5.8F, 0.0F, 6.5F, "C+", "Đạt", 1);
        Point point3 = new Point(3, "INT13147", "Thực tập cơ sở", 3, 10, 20, 20, 0, 50, 10.0F,
                8.0F, 9.0F, 0.0F, 8.0F, 0.0F, 8.4F, "B+", "Đạt", 1);

        List<Point> pointList = Arrays.asList(point1, point2, point3);

        PointAdapter pointAdapter = new PointAdapter(Collections.singletonList(pointList));
        String actualResult = pointAdapter.tbHK(pointList);
        String expectedResult = "2.33";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGPA() {
        Point point1 = new Point(3, "INT1434", "Lập trình Web", 3, 10, 20, 20, 0, 50, 8.0F,
                7.0F, 7.0F, 0.0F, 1.0F, 0.0F, 4.1F, "D", "Đạt", 1);
        Point point2 = new Point(3, "INT14148", "Cơ sở dữ liệu phân tán", 3, 10, 10, 0, 20, 60, 9.0F,
                8.3F, 0.0F, 6.2F, 5.8F, 0.0F, 6.5F, "C+", "Đạt", 1);
        Point point3 = new Point(3, "INT13147", "Thực tập cơ sở", 3, 10, 20, 20, 0, 50, 10.0F,
                8.0F, 9.0F, 0.0F, 8.0F, 0.0F, 8.4F, "B+", "Đạt", 1);
        List<Point> pointList1 = Arrays.asList(point1, point2);
        List<Point> pointList2 = Arrays.asList(point3);
        List<List<Point>> list = new ArrayList<>();
        list.add(pointList1);
        list.add(pointList2);

        PointAdapter pointAdapter = new PointAdapter(list);
        String actualResult = pointAdapter.GPA(list);
        String expectedResult = "2.33";
        Assert.assertEquals(expectedResult, actualResult);
    }
}