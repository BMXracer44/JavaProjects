package InheritanceProject;

class Main {
    public static void main(String[] args) {
      Shop myBikes = new Shop();

      myBikes.AddItem(
        new Fullsuspension("Trek fuel", 5000, 120, true)
      );

      myBikes.AddItem(
        new Dirtjumper("Kona", 1500)
      );

      myBikes.DisplayInventory();
    }
  }