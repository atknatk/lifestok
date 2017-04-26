package com.lifeweb.ui.satis;

import com.jidesoft.chart.Chart;
import com.jidesoft.chart.ChartType;
import com.jidesoft.chart.model.*;
import com.jidesoft.chart.render.*;
import com.jidesoft.chart.style.ChartStyle;
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class IndirimChartPanel {

    private static final float outlineWidth = 3f;
    private ChartStyle r, g;
    private ChartCategory<String> red, green;
    private Chart pieChart;
    private JPanel demoPanel;
    private ChartStyle style;
    private DefaultChartModel chartModel;
    private Highlight redHighlight;
    private Highlight greenHighlight;

    private JPanel createDemo(double net, double ind) {
        demoPanel = new JPanel();
        demoPanel.setMinimumSize(new Dimension(290, 200));
        demoPanel.setLayout(new GridLayout(2, 1));

        redHighlight = new Highlight("İndirim");
        greenHighlight = new Highlight("Ödenecek");

        red = new ChartCategory<String>("İndirim", redHighlight);
        green = new ChartCategory<String>("Ödenecek", greenHighlight);

        r = new ChartStyle(new Color(255, 64, 64, 245));
        g = new ChartStyle(new Color(64, 255, 64, 245));

        chartModel = new DefaultChartModel("Sample Model");
        chartModel.addPoint(new ChartPoint(red, new RealPosition(ind), redHighlight));
        chartModel.addPoint(new ChartPoint(green, new RealPosition(net), greenHighlight));

        pieChart = new Chart(new Dimension(290, 150));
        demoPanel.add(pieChart);
        pieChart.setTitle("İndirim Pie");
        pieChart.setPreferredSize(new Dimension(290, 150));
        pieChart.addModel(chartModel);
        pieChart.setChartType(ChartType.PIE);
        pieChart.setStyle(chartModel, style);
        pieChart.setSelectionShowsOutline(true);
        pieChart.setAnimateOnShow(true);
        pieChart.setShadowVisible(true);
        pieChart.setSelectionEnabled(true);
        pieChart.setRolloverEnabled(true);
        pieChart.setAllowTickLabelOverlap(true);
        pieChart.setSelectionShowsExplodedSegments(true);
        DefaultPieSegmentRenderer pieRenderer = (DefaultPieSegmentRenderer) pieChart.getPieSegmentRenderer();
        pieRenderer.setAlwaysShowOutlines(true);
        pieRenderer.setOutlineWidth(outlineWidth);
        useColorHighlights();
        return demoPanel;
    }

    private void useColorHighlights(Chart chart) {
        chart.setHighlightStyle(red.getHighlight(), new ChartStyle(r).withBars());
        chart.setHighlightStyle(green.getHighlight(), new ChartStyle(g).withBars());
    }

    private void useColorHighlights() {
        useColorHighlights(pieChart);
        //   useColorHighlights(barChart);
    }

    public Component getDemoPanel(double net, double ind) {
        if (demoPanel == null) {
            demoPanel = createDemo(net, ind);
        }
        chartModel.replacePoint(0,new ChartPoint(red, new RealPosition(ind), redHighlight));
        chartModel.replacePoint(1,new ChartPoint(green, new RealPosition(net), greenHighlight));
        return demoPanel;
    }

    public void reset(){
        demoPanel=null;
    }
    
    
}
