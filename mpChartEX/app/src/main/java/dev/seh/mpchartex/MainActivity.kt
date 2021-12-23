package dev.seh.mpchartex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.github.mikephil.charting.utils.ColorTemplate

class MainActivity : AppCompatActivity() {
    private lateinit var pieChart: PieChart
    private lateinit var barChart:BarChart
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pieChart = findViewById(R.id.mp_pie_chart)
        barChart = findViewById(R.id.mp_bar_chart)
        setPieData()
        setBarData()


    }
    private fun setPieData(){
        val entries = arrayListOf<PieEntry>()
        entries.add(PieEntry(10.0f))
        entries.add(PieEntry(23.0f))
        entries.add(PieEntry(37.0f))
        entries.add(PieEntry(30.0f))
        val dataset = PieDataSet(entries,"asd")
        val colors = arrayListOf<Int>()
        val cTemp = ColorTemplate.VORDIPLOM_COLORS
        colors.add(cTemp[0])
        colors.add(cTemp[1])
        colors.add(cTemp[2])
        colors.add(cTemp[3])

        dataset.colors = colors
        val data = PieData(dataset)

        pieChart.data = data

    }
    private fun setBarData(){
        val entries = arrayListOf<BarEntry>()
        entries.add(BarEntry(0f,10f))
        entries.add(BarEntry(1f,14f))
        val barDataSet = BarDataSet(entries,"fd")

        val dataSet = arrayListOf<IBarDataSet>()
        dataSet.add(barDataSet)
        val barData = BarData(dataSet)
        barChart.data = barData
    }
}