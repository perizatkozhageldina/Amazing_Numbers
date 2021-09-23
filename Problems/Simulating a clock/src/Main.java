class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {
        this.minutes++;
        if (this.minutes == 60) {
            this.minutes = 0;
            if (this.hours == 12) {
                this.hours = 0;
            }
            this.hours++;
        }
    }
}