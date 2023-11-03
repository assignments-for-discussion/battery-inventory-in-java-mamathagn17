package bunchbysoh;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  };

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    CountsBySoH counts = new CountsBySoH();
     for (int capacity : presentCapacities) {
      double soh = (capacity * 100.0) / 120;
      if (soh > 80) {
        counts.healthy++;
      } else if (soh >= 62) {
        counts.exchange++;
      } else {
        counts.failed++;
      }
    }
    return counts;
  }

  static void testBucketingByHealth() {
    System.out.println("Counting batteries by SoH...\n");
    int[] presentCapacities = {113, 116, 80, 95, 92, 70};
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);
    System.out.println("Done counting :)\n");
    int[] presentCapacities2 = {120, 120, 120, 120};
    CountsBySoH counts2 = countBatteriesByHealth(presentCapacities3);
    assert(counts2.healthy == 4);
    assert(counts2.exchange == 0);
    assert(counts2.failed == 0);
    int[] presentCapacities3 = {45, 50, 48, 50};
    CountsBySoH counts3 = countBatteriesByHealth(presentCapacities3);
    assert(counts3.healthy == 0);
    assert(counts3.exchange == 0);
    assert(counts3.failed == 4);
   int[] presentCapacities4 = {110, 115, 75, 60,100,90};
    CountsBySoH counts4 = countBatteriesByHealth(presentCapacities3);
    assert(counts4.healthy == 2);
    assert(counts4.exchange == 1);
    assert(counts4.failed == 1);

  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
