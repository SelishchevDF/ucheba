import java.util.Comparator;

public class AverageSalaryPerMonthComporator implements Comparator<BaseWorker> {

    @Override
    public int compare(BaseWorker o1, BaseWorker o2) {
    double res = o1.getAverageSalaryPerMonth() - o2.getAverageSalaryPerMonth();
    int resInteger = (int)res;
    return resInteger;
    }
}