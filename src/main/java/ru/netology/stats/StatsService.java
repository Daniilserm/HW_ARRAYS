package ru.netology.stats;

public class StatsService {
    public int sumSales(long[] sales) { // сумма всех продаж
        long sum = 0;
        for (int i = 0; i < sales.length; i++) {
            sum = sum + sales[i];
        }

        return (int) sum;
    }

    public int averageSales(long[] sales) { // средняя сумма продаж в месяц
        int average = sumSales(sales) / 12;

        return average;
    }

    public int maxSales(long[] sales) { // номер месяца, в котором был пик продаж, то есть осуществлены продажи на максимальную сумму
        int maxMonth = 0;

        for (int i = 0; i < sales.length; i++) {
            if (sales[i] >= sales[maxMonth]) {
                maxMonth = i;
            }
        }

        return maxMonth + 1;
    }

    public int minSales(long[] sales) { // номер месяца, в котором был минимум продаж, то есть осуществлены продажи на минимальную сумму
        int minMonth = 0; // номер месяца с минимальными продажами среди просмотренных ранее

        for (int i = 0; i < sales.length; i++) {
            if (sales[i] <= sales[minMonth]) { // значит, в рассматриваемом i-м месяце продаж меньше
                minMonth = i; // запомним его как минимальный
            }
        }

        return minMonth + 1; // месяца нумеруются с 1, а индексы массива с 0, нужно сдвинуть ответ на 1
    }

    public int lowAverage(long[] sales) { // количество месяцев, в которых продажи были ниже среднего
        int low = 0;

        for (int i = 0; i < sales.length; i++) {
            if (sales[i] < averageSales(sales)) {
                low++;
            }
        }

        return low;
    }

    public int higherAverage(long[] sales) { // количество месяцев, в которых продажи были выше среднего
        int higher = 0;

        for (int i = 0; i < sales.length; i++) {
            if (sales[i] > averageSales(sales)) {
                higher++;
            }
        }

        return higher;
    }

}
