
public class Stav {
	
	int c_stavu;

	public Stav(int c_stavu) {
		this.c_stavu = c_stavu;
	}
	
	void drawStav(TrafficLight [] carTL, TrafficLight2 [] pedestTL) {
		switch(c_stavu) {
		case 1:
			carTL[0].stop();
			carTL[1].stop();
			
			carTL[2].go();
			carTL[3].go();
			carTL[4].stop();
			
			carTL[5].go();
			carTL[6].stop();
			carTL[7].stop();
			
			carTL[8].stop();
			carTL[9].stop();
			carTL[10].stop();
			
			pedestTL[0].stop();
			pedestTL[1].stop();
			
			pedestTL[2].stop();
			pedestTL[3].stop();
			
			pedestTL[4].go();
			pedestTL[5].go();
		break;	
		case 2:
			carTL[0].stop();
			carTL[1].stop();
			
			carTL[2].go();
			carTL[3].go();
			carTL[4].readyStop();
			
			carTL[5].go();
			carTL[6].stop();
			carTL[7].stop();
			
			carTL[8].stop();
			carTL[9].stop();
			carTL[10].stop();
			
			pedestTL[0].stop();
			pedestTL[1].stop();
			
			pedestTL[2].stop();
			pedestTL[3].stop();
			
			pedestTL[4].go();
			pedestTL[5].go();
		break;
		case 3:
			carTL[0].stop();
			carTL[1].stop();
			
			carTL[2].go();
			carTL[3].go();
			carTL[4].go();
			
			carTL[5].go();
			carTL[6].stop();
			carTL[7].stop();
			
			carTL[8].stop();
			carTL[9].stop();
			carTL[10].stop();
			
			pedestTL[0].stop();
			pedestTL[1].stop();
			
			pedestTL[2].stop();
			pedestTL[3].stop();
			
			pedestTL[4].go();
			pedestTL[5].go();
		break;
		case 4:
			carTL[0].readyStop();
			carTL[1].readyStop();
			
			carTL[2].go();
			carTL[3].go();
			carTL[4].ready();
			
			carTL[5].ready();
			carTL[6].stop();
			carTL[7].stop();
			
			carTL[8].stop();
			carTL[9].stop();
			carTL[10].stop();
			
			pedestTL[0].stop();
			pedestTL[1].stop();
			
			pedestTL[2].stop();
			pedestTL[3].stop();
			
			pedestTL[4].go();
			pedestTL[5].go();
		break;
		case 5:
			carTL[0].go();
			carTL[1].go();
			
			carTL[2].go();
			carTL[3].go();
			carTL[4].stop();
			
			carTL[5].stop();
			carTL[6].stop();
			carTL[7].stop();
			
			carTL[8].stop();
			carTL[9].stop();
			carTL[10].stop();
			
			pedestTL[0].stop();
			pedestTL[1].stop();
			
			pedestTL[2].go();
			pedestTL[3].go();
			
			pedestTL[4].go();
			pedestTL[5].go();
		break;
		case 6:
			carTL[0].ready();
			carTL[1].ready();
			
			carTL[2].ready();
			carTL[3].ready();
			carTL[4].stop();
			
			carTL[5].readyStop();
			carTL[6].readyStop();
			carTL[7].stop();
			
			carTL[8].readyStop();
			carTL[9].readyStop();
			carTL[10].readyStop();
			
			pedestTL[0].stop();
			pedestTL[1].stop();
			
			pedestTL[2].stop();
			pedestTL[3].stop();
			
			pedestTL[4].stop();
			pedestTL[5].stop();
		break;
		case 7:
			carTL[0].stop();
			carTL[1].stop();
			
			carTL[2].stop();
			carTL[3].stop();
			carTL[4].stop();
			
			carTL[5].go();
			carTL[6].go();
			carTL[7].stop();
			
			carTL[8].go();
			carTL[9].go();
			carTL[10].go();
			
			pedestTL[0].go();
			pedestTL[1].go();
			
			pedestTL[2].stop();
			pedestTL[3].stop();
			
			pedestTL[4].stop();
			pedestTL[5].stop();
		break;
		case 8:
			carTL[0].readyStop();
			carTL[1].stop();
			
			carTL[2].stop();
			carTL[3].stop();
			carTL[4].stop();
			
			carTL[5].go();
			carTL[6].go();
			carTL[7].readyStop();
			
			carTL[8].ready();
			carTL[9].ready();
			carTL[10].ready();
			
			pedestTL[0].stop();
			pedestTL[1].stop();
			
			pedestTL[2].stop();
			pedestTL[3].stop();
			
			pedestTL[4].stop();
			pedestTL[5].stop();
		break;
		case 9:
			carTL[0].go();
			carTL[1].stop();
			
			carTL[2].stop();
			carTL[3].stop();
			carTL[4].stop();
			
			carTL[5].go();
			carTL[6].go();
			carTL[7].go();
			
			carTL[8].stop();
			carTL[9].stop();
			carTL[10].stop();
			
			pedestTL[0].stop();
			pedestTL[1].stop();
			
			pedestTL[2].stop();
			pedestTL[3].stop();
			
			pedestTL[4].stop();
			pedestTL[5].stop();
		break;
		case 10:
			carTL[0].ready();
			carTL[1].stop();
			
			carTL[2].readyStop();
			carTL[3].readyStop();
			carTL[4].stop();
			
			carTL[5].go();
			carTL[6].readyStop();
			carTL[7].readyStop();
			
			carTL[8].stop();
			carTL[9].stop();
			carTL[10].stop();
			
			pedestTL[0].stop();
			pedestTL[1].stop();
			
			pedestTL[2].stop();
			pedestTL[3].stop();
			
			pedestTL[4].stop();
			pedestTL[5].stop();
		break;
		case 11:
			for(int i = 0; i < 11; i++) {
				carTL[i].ready();
			}
			for(int i = 0; i < 6; i++) {
				pedestTL[i].stop();
			}
		break;	
		case 12:
			for(int i = 0; i < 11; i++) {
				carTL[i].turnOff();
			}
			for(int i = 0; i < 6; i++) {
				pedestTL[i].turnOff();
			}
		break;
		case 13:
			for(int i = 0; i < 11; i++) {
				carTL[i].ready();
			}
			for(int i = 0; i < 6; i++) {
				pedestTL[i].turnOff();
			}
		break;
		default:
			for(int i = 0; i < 11; i++) {
				carTL[i].turnOff();
			}
			for(int i = 0; i < 6; i++) {
				pedestTL[i].turnOff();
			}
		}
	}

}
