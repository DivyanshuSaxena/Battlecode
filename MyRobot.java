package bc19;

public class MyRobot extends BCAbstractRobot {
	public int turn;
    public int pilgrim = 0;
    public int crusader = 0;
    public boolean[][] m = map;
    public boolean[][] kmap = karboniteMap;
    public boolean[][] fmap = fuelMap;


    public Action turn() {
    	turn++;
        int[][] occ = getVisibleRobotMap();
    	if (me.unit == SPECS.CASTLE) {
                
            if (pilgrim <= 2)
            {
                pilgrim++;

        		    if (me.x+1<m.length && occ[me.x + 1][me.y] == 0 && m[me.x + 1][me.y] == true && (kmap[me.x + 1][me.y] == true || fmap[me.x + 1][me.y] == true))
                        return buildUnit(SPECS.PILGRIM,me.x + 1,me.y);
                	else if (me.x+1<m.length && me.y+1<m.length && occ[me.x + 1][me.y + 1] == 0 && m[me.x + 1][me.y + 1] == true && (kmap[me.x + 1][me.y + 1] == true || fmap[me.x + 1][me.y + 1] == true))
                        return buildUnit(SPECS.PILGRIM,me.x + 1,me.y + 1);
                    else if (me.y+1<m.length && occ[me.x][me.y + 1] == 0 && m[me.x][me.y + 1] == true && (kmap[me.x][me.y + 1] == true || fmap[me.x][me.y + 1] == true))
                        return buildUnit(SPECS.PILGRIM,me.x,me.y + 1);
                    else if (me.x-1>=0&&me.y+1<m.length&& occ[me.x - 1][me.y + 1] == 0 &&m[me.x - 1][me.y + 1] == true && (kmap[me.x - 1][me.y + 1] == true || fmap[me.x - 1][me.y + 1] == true))
                        return buildUnit(SPECS.PILGRIM,me.x - 1,me.y + 1);
                    else if (me.x-1>=0&& occ[me.x - 1][me.y] == 0 && m[me.x - 1][me.y] == true && (kmap[me.x - 1][me.y] == true || fmap[me.x - 1][me.y] == true))
                        return buildUnit(SPECS.PILGRIM,me.x - 1,me.y);
                    else if (me.x-1>=0&&me.y-1>=0&& occ[me.x - 1][me.y - 1] == 0 && m[me.x - 1][me.y - 1] == true && (kmap[me.x - 1][me.y - 1] == true || fmap[me.x - 1][me.y - 1] == true))
                        return buildUnit(SPECS.PILGRIM,me.x - 1,me.y - 1);
                    else if (me.y-1>=0 && occ[me.x][me.y - 1] == 0 &&m[me.x][me.y - 1] == true && (kmap[me.x][me.y - 1] == true || fmap[me.x][me.y - 1] == true))
                        return buildUnit(SPECS.PILGRIM,me.x,me.y - 1);
                    else if (me.y-1>=0&&me.x+1<m.length&& occ[me.x + 1][me.y - 1] == 0 && m[me.x + 1][me.y - 1] == true && (kmap[me.x + 1][me.y - 1] == true || fmap[me.x + 1][me.y - 1] == true))
                        return buildUnit(SPECS.PILGRIM,me.x + 1,me.y - 1);

                // return buildUnit(SPECS.PILGRIM,1,0);
            }
            else if (crusader <=2)
            {
                crusader++;
                return buildUnit(3,1,0);//crusader   
            }
    		
    	}

    	if (me.unit == SPECS.PILGRIM) {
    		// if (turn == 1) {
    			log("I am a pilgrim.");
                if (kmap[me.x][me.y] == true || fmap[me.x][me.y] == true) {
                    return mine();
                }

                // if (me.x+1<map.length&&map[me.x + 1][me.y] == true && (kmap[me.x + 1][me.y] == true || fmap[me.x + 1][me.y] == true))
                //     return move(me.x + 1,me.y);
                // else if (me.x+1<map.length&&me.y+1<map.length&&map[me.x + 1][me.y + 1] == true && (kmap[me.x + 1][me.y + 1] == true || fmap[me.x + 1][me.y + 1] == true))
                //     return move(me.x + 1,me.y + 1);
                // else if (me.y+1<map.length&&map[me.x][me.y + 1] == true && (kmap[me.x][me.y + 1] == true || fmap[me.x][me.y + 1] == true))
                //     return move(me.x,me.y + 1);
                // else if (me.x-1>=0&&me.y+1<map.length&&map[me.x - 1][me.y + 1] == true && (kmap[me.x - 1][me.y + 1] == true || fmap[me.x - 1][me.y + 1] == true))
                //     return move(me.x - 1,me.y + 1);
                // else if (me.x-1>=0&&map[me.x - 1][me.y] == true && (kmap[me.x - 1][me.y] == true || fmap[me.x - 1][me.y] == true))
                //     return move(me.x - 1,me.y);
                // else if (me.x-1>=0&&me.y-1>=0&&map[me.x - 1][me.y - 1] == true && (kmap[me.x - 1][me.y - 1] == true || fmap[me.x - 1][me.y - 1] == true))
                //     return move(me.x - 1,me.y - 1);
                // else if (me.y-1>=0&&map[me.x][me.y - 1] == true && (kmap[me.x][me.y - 1] == true || fmap[me.x][me.y - 1] == true))
                //     return move(me.x,me.y - 1);
                // else if (me.y-1>=0&&me.x+1<map.length&&map[me.x + 1][me.y - 1] == true && (kmap[me.x + 1][me.y - 1] == true || fmap[me.x + 1][me.y - 1] == true))
                //     return move(me.x + 1,me.y - 1);
                
                //log(Integer.toString([0][getVisibleRobots()[0].castle_talk]));
    		// }
    	}

    	return null;

	}
}