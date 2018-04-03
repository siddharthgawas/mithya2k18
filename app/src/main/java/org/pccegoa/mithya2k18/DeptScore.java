package org.pccegoa.mithya2k18;

        import android.content.Intent;
        import android.graphics.Color;
        import android.support.v7.app.ActionBar;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Toolbar;

        import com.github.mikephil.charting.animation.Easing;
        import com.github.mikephil.charting.charts.PieChart;
        import com.github.mikephil.charting.components.Legend;
        import com.github.mikephil.charting.data.PieData;
        import com.github.mikephil.charting.data.PieDataSet;
        import com.github.mikephil.charting.data.PieEntry;
        import com.github.mikephil.charting.formatter.PercentFormatter;
        import com.github.mikephil.charting.utils.ColorTemplate;

        import java.util.ArrayList;
        import java.util.List;

        public class DeptScore extends AppCompatActivity {

            PieChart ScoreChart;
            int mechScore, compScore, etcScore, itScore;

            @Override
                 protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_dept_score);

                       ScoreChart = (PieChart) findViewById(R.id.deptScorechart);
               updatePieChart(25,25,25,25);

               android.support.v7.widget.Toolbar toolbar =  findViewById(R.id.toolbar);
                setSupportActionBar(toolbar);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setDisplayShowHomeEnabled(true);
                toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getApplicationContext(),DashboardActivity.class));
                    }
                });
           }
            public void updatePieChart(int Mscore, int Cscore, int Escore, int Iscore) {
                List<PieEntry> entries = new ArrayList<>();
                entries.add(new PieEntry(Mscore, "MECH"));
                entries.add(new PieEntry(Cscore, "COMP"));
                entries.add(new PieEntry(Escore, "ETC"));
                entries.add(new PieEntry(Iscore, "IT"));
                PieDataSet set = new PieDataSet(entries,"");
                set.setColors(ColorTemplate.MATERIAL_COLORS);
                PieData data = new PieData(set);
                data.setValueTextSize(12f);
                data.setValueTextColor(Color.BLACK);
                ScoreChart.setData(data);
                set.setValueFormatter(new PercentFormatter());
                ScoreChart.getDescription().setEnabled(false);
                ScoreChart.setHoleRadius(5);
                ScoreChart.setExtraBottomOffset(25);
                ScoreChart.animateY(1250, Easing.EasingOption.EaseInOutCirc);
                ScoreChart.invalidate();
                ScoreChart.setTransparentCircleAlpha(0);
                Legend legend = ScoreChart.getLegend();
                legend.setFormSize(20);
                legend.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
                legend.setYEntrySpace(10);
            }
}
