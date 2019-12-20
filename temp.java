    private int[][] blocks = null;
    private int lb = 0;
    private boolean valid = false;

    public int robotSim(int[] commands, int[][] obstacles) {
        int dir = 0, x = 0, y = 0, lc = commands.length;
        blocks = obstacles;
        lb = obstacles.length;
        for (int i = 0; i < lc; ++i) {
            if (commands[i] == -2) {
                if (--dir < 0) {
                    dir = 3;
                }
            } else if (commands[i] == -1) {
                if (++dir > 3) {
                    dir = 0;
                }
            } else {
                switch (dir) {
                case 0:
                    y = check(0, 1, x, y, y + commands[i], true);
                    break;
                case 1:
                    x = check(1, 0, y, x, x + commands[i], true);
                    break;
                case 2:
                    y = check(0, 1, x, y, y - commands[i], false);
                    break;
                case 3:
                    x = check(1, 0, y, x, x - commands[i], false);
                    break;
                }
            }
        }
        return x * x + y * y;
    }
    private int check(int unchange, int change, int persist, int before, int after, boolean getMin) {
        valid = false;
        int target = 0, curr;
        if (getMin) {
            for (int i = 0; i < lb; ++i) {
                if (blocks[i][unchange] == persist) {
                    curr = blocks[i][change];
                    if (curr > before && curr <= after) {
                        if (valid) {
                            if (curr < target) {
                                target = curr;
                            }
                        } else {
                            target = curr;
                            valid = true;
                        }
                    }
                }
            }
            if (valid) {
                after = target - 1;
            }
        } else {
            for (int i = 0; i < lb; ++i) {
                if (blocks[i][unchange] == persist) {
                    curr = blocks[i][change];
                    if (curr < before && curr >= after) {
                        if (valid) {
                            if (curr > target) {
                                target = curr;
                            }
                        } else {
                            target = curr;
                            valid = true;
                        }
                    }
                }
            }
            if (valid) {
                after = target + 1;
            }
        }
        return after;
    }