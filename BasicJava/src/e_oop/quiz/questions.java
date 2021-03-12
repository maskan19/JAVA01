package e_oop.quiz;

import java.util.Scanner;

public class questions {

	Scanner s = new Scanner(System.in);
	int[] ans = new int[40];
	void q1(){
		System.out.println("1.활발하다  \t2.모험적이다\t3.분석적이다\t4.융통성있다");
		ans[0] = Integer.parseInt(s.nextLine());
		q2();
	}
	void q2(){
		System.out.println("1.쾌활하다  \t2.설득력이 있다\t3.끈기 있다  \t4.평온하다");
		ans[1] = Integer.parseInt(s.nextLine());
		q3();
	}
	void q3(){
		System.out.println("1.사교적이다\t2.의지가 강하다\t3.희생적이다\t4.순응한다");
		ans[2] = Integer.parseInt(s.nextLine());
		q4();
	}
	void q4(){
		System.out.println("1.매력있다  \t2.경쟁심이 있다\t3.이해심이 많다\t4.감정을 억제한다");
		ans[3] = Integer.parseInt(s.nextLine());
		q5();
	}
	void q5(){
		System.out.println("1.참신하다  \t2.끼가 많다 \t3.공손하다  \t4.수줍어함");
		ans[4] = Integer.parseInt(s.nextLine());
		q6();
	}
	void q6(){
		System.out.println("1.활발함     \t2.독자적인 편\t3.민감한 편  \t4.수용하는 편");
		ans[5] = Integer.parseInt(s.nextLine());
		q7();
	}
	void q7(){
		System.out.println("1.주동적이다\t2.긍정적이다\t3.계획한다  \t4.참을성이 있다");
		ans[6] = Integer.parseInt(s.nextLine());
		q8();
	}
	void q8(){
		System.out.println("1.충동적     \t2.자신에 참  \t3.계획을  따르는 편\t4.과묵하다");
		ans[7] = Integer.parseInt(s.nextLine());
		q9();
	}
	void q9(){
		System.out.println("1.낙천적     \t2.솔직함     \t3.질서정연      \t4.포용력 있다");
		ans[8] = Integer.parseInt(s.nextLine());
		q10();
	}
	void q10(){
		System.out.println("1.익살스러움\t2.주관이 뚜렷하다\t3.신실함       \t4.친절함");
		ans[9] = Integer.parseInt(s.nextLine());
		q11();
	}
	void q11(){
		System.out.println("1.즐겁다     \t2.겁이 없다    \t3.섬세하다      \t4.싹싹하다");
		ans[10] = Integer.parseInt(s.nextLine());
		q12();
	}
	void q12(){
		System.out.println("1.명랑하다   \t2.자신감 있다\t3.문화적이다\t4.안정되다");
		ans[11] = Integer.parseInt(s.nextLine());
		q13();
	}
	void q13(){
		System.out.println("1.고무적     \t2.독립적      \t3.이상적     \t4.유순함");
		ans[12] = Integer.parseInt(s.nextLine());
		q14();
	}
	void q14(){
		System.out.println("1.표현하는 편\t2.단호하다  \t3.몰두하는 편\t4.천연덕스러움");
		ans[13] = Integer.parseInt(s.nextLine());
		q15();
	}
	void q15(){
		System.out.println("1.쉽게 어울린다\t2.의견 제안 잘함\t3.음악을 좋아한다\t4.중재자");
		ans[14] = Integer.parseInt(s.nextLine());
		q16();
	}
	void q16(){
		System.out.println("1.말하기 좋아한다\t2.성취 지향적\t3.사려 깊은 편\t4.관대하다");
		ans[15] = Integer.parseInt(s.nextLine());
		q17();
	}
	void q17(){
		System.out.println("1.열정적이다\t2.책임감이 있다\t3.충성스러운 편\t4.잘 듣는다");
		ans[16] = Integer.parseInt(s.nextLine());
		q18();
	}
	void q18(){
		System.out.println("1.무대형이다\t2.지도력이 있다\t3.조직적이다\t4.만족하는 편");
		ans[17] = Integer.parseInt(s.nextLine());
		q19();
	}
	void q19(){
		System.out.println("1.인기 있다  \t2.생산적이다\t3.완벽을 추구한다\t4.편안하다");
		ans[18] = Integer.parseInt(s.nextLine());
		q20();
	}
	void q20(){
		System.out.println("1.활기 있다   \t2.대담하다     \t3.예의바르다\t4.균형잡힘");
		ans[19] = Integer.parseInt(s.nextLine());
	}
	/********/
	void q21(){
		System.out.println("1.허세를 부린다\t2.명령형 보스 기질\t3.수줍어함   \t4.무표정하다");
		ans[20] = Integer.parseInt(s.nextLine());
		q22();
	}
	void q22(){
		System.out.println("1.규율이 없다\t2.냉정함      \t3.용서 안 함 \t4.열정 없음");
		ans[21] = Integer.parseInt(s.nextLine());
		q23();
	}
	void q23(){
		System.out.println("1.장황함      \t2.반항적     \t3.화 잘 냄    \t4.마지못해 함");
		ans[22] = Integer.parseInt(s.nextLine());
		q24();
	}
	void q24(){
		System.out.println("1.잘 잊음    \t2.솔직함      \t3.까다로움   \t4.두려워 함");
		ans[23] = Integer.parseInt(s.nextLine());
		q25();
	}
	void q25(){
		System.out.println("1.끼어들기    \t2.참을성 없음\t3.자신감 없음\t4.우유부단함");
		ans[24] = Integer.parseInt(s.nextLine());
		q26();
	}
	void q26(){
		System.out.println("1.예측불허   \t2.애정표현이 없다\t3.인기 없음  \t4.끼어들기");
		ans[25] = Integer.parseInt(s.nextLine());
		q27();
	}
	void q27(){
		System.out.println("1.되는대로 성격\t2.완고함      \t3.불만이 많은 편\t4.주저");
		ans[26] = Integer.parseInt(s.nextLine());
		q28();
	}
	void q28(){
		System.out.println("1.허용적      \t2.교만함      \t3.비관적      \t4.평범함");
		ans[27] = Integer.parseInt(s.nextLine());
		q29();
	}
	void q29(){
		System.out.println("1.쉽게 성냄  \t2.논쟁을 좋아함\t3.자신을 격리함\t4.목표 없음");
		ans[28] = Integer.parseInt(s.nextLine());
		q30();
	}
	void q30(){
		System.out.println("1.순진함      \t2.자만한다  \t3.부정적이다\t4.안일하다");
		ans[29] = Integer.parseInt(s.nextLine());
		q31();
	}
	void q31(){
		System.out.println("1.칭찬을 바란다\t2.일에 미침  \t3.뒤로 물러서는 편\t4.근심이 많음");
		ans[30] = Integer.parseInt(s.nextLine());
		q32();
	}
	void q32(){
		System.out.println("1.말 많음      \t2.무뚝뚝함   \t3.지나치게 예민\t4.소심함");
		ans[31] = Integer.parseInt(s.nextLine());
		q33();
	}
	void q33(){
		System.out.println("1.무질서함   \t2.지배적임   \t3.낙심 잘함 \t4.결단력 약함");
		ans[32] = Integer.parseInt(s.nextLine());
		q34();
	}
	void q34(){
		System.out.println("1.일관성 없음 \t2.관대하지 못함\t3.내성적     \t4.무관심");
		ans[33] = Integer.parseInt(s.nextLine());
		q35();
	}
	void q35(){
		System.out.println("1.지저분함  \t2.남을 이용함\t3.침울함      \t4.불평 잘 함");
		ans[34] = Integer.parseInt(s.nextLine());
		q36();
	}
	void q36(){
		System.out.println("1.과시적      \t2.고집 셈     \t3.회의적      \t4.느림");
		ans[35] = Integer.parseInt(s.nextLine());
		q37();
	}
	void q37(){
		System.out.println("1.목소리가 큼\t2.주장이 강함\t3.고독 즐김 \t4.게으름");
		ans[36] = Integer.parseInt(s.nextLine());
		q38();
	}
	void q38(){
		System.out.println("1.산만한 편 \t2.성미 급함 \t3.의심 많음 \t4.행동 느림");
		ans[37] = Integer.parseInt(s.nextLine());
		q39();
	}
	void q39(){
		System.out.println("1.침착하지 못함\t2.신중치 못함\t3.복수심 강함\t4.억지로 함");
		ans[38] = Integer.parseInt(s.nextLine());
		q40();
	}
	void q40(){
		System.out.println("1.변덕스러움\t2.약삭빠름  \t3.비판적      \t4.타협적");
		ans[39] = Integer.parseInt(s.nextLine());
	}
	
	/********/
	String tend1="";
	String tend2="";
	
	void result(int a, int  b){
		switch(a){
		case 0:
			tend1 = "다혈";
			break;
		case 1:
			tend1 = "담즙";
			break;
		case 2:
			tend1 = "우울";
			break;
		case 3:
			tend1 = "점액";
			break;
		}
		switch(b){
		case 0:
			tend2 = "다혈";
			break;
		case 1:
			tend2 = "담즙";
			break;
		case 2:
			tend2 = "우울";
			break;
		case 3:
			tend2 = "점액";
			break;
		}
		System.out.println("당신은 " + tend1 + "-" + tend2 + "질");
	}
	
	void result1(){
		System.out.println("1. 다혈담즙(탁월한 지도자)\n 따뜻하고 열정적이며 순발력이 뛰어나다. 대인관계에 연관된 분야에서 뛰어난 성과를 보이며 일 처리도 빠르다. 전반적으로 외향적인 스타일이라 모든 사람과 사귀길 원하는 타입. 그러나 지나치게 말이 많아 손해를 많이 보며 자기 과시가 심한 면이 있고 감정의 절제가 약하다.");}
	void result2(){
		System.out.println("2. 다혈점액(즐거움을 주는 사람)\n유머가 뛰어나고 둥글둥글한 성격 덕에 누구나 다 좋아할 수 있는 사람으로 친절하고 낙천적. 동정심이 많고 어떤 상황이든 잘 적응하는 스타일로 즐거운 분위기를 만드는데 타고난 기질. 단, 집중력과 자제력이 약하며 깊이가 결여되는 부분이 있고 너무 긍정적인 탓에 상황의 심각성을 잘 느끼지 못해 진지하지 못한 부분이 있다.");}
	void result3(){
		System.out.println("3. 다혈우울(섬세한 팔방미인)\n기본적으로 감정기복이 심하고 감수성이 풍부해 공감할 수 있는 능력이 뛰어나다. 이야기도 재밌게 잘하는 편이라 주위에 사람이 많은 편. 독창성과 창의력이 있어 새로운 일을 시도하려는 경향이 강하고 솔선수범하는 면도 있다. 단점으로는 인정받고 싶은 욕구가 커 다른 사람 눈치를 많이 보며 거짓말을 잘해 항상 가면을 쓰는 경우가 많다.");}
	void result4(){
		System.out.println("4. 담즙다혈(타고난 카리스마)\n목적의식이 뚜렷하고 모험심도 강하고 열정이 많은 스타일이라 사람들에게 동기를 유발할 수 있다. 정이나 감정보단 냉정한 판단을 내리는데 탁월하고 소신껏 행동하는 모습을 보인다. 하지만 시작하면 안 되었을 계획도 끝까지 고집하는 경향이 있으며 독단적이고 편견에 사로잡힐 수가 있고 성급한 행동으로 다른 사람에게 피해를 줄 수 있다.");}
	void result5(){
		System.out.println("5. 담즙우울(섬세하고 뛰어난 언변가)\n매사에 철두철미하고 사리분별력이 뛰어난 편이라 일 처리를 할 때도 신중하고 책임감이 강한 편이다. 독립심이 강하고 고집이 세고 활동적인 독불장군 같은 사람. 존경과 증오를 동시에 받는 독재자 스타일이 될 수 있다.");}
	void result6(){
		System.out.println("6. 담즙점액(타고난 행정가)\n외향적 기질이지만 신중하면서 조용하고 차분한 스타일.	차분한 성격 탓에 장기적인 계획도 잘 달성하며 조직적으로 일 처리를 하는데 탁월하다. 목표가 뚜렷하고 확실하게 일을 하므로 사람들이 같이 일하기를 좋아한다. 단점은 자신의 실수를 잘 인정하지 않고 고집이 너무 강한 편");}
	void result7(){
		System.out.println("7. 우울담즙(철저한 준비성이 있는 사람)\n욕심이 많고 다소 번잡한 기질. 자기 스스로 자신으로 비판하는 건 되지만 남이 나를 비판하는 건 절대 싫어한다. 준비성이 뛰어나 유능하고 지도력이 뛰어나며 능률이 중요해 모든 일을 효율적으로 처리하는데 탁월한 능력이 있다. 그러나 지나친 적대감과 비평의 성향이 있으며 감정을 잘 감추지 못하는 편.");}
	void result8(){
		System.out.println("8. 우울점액(탁월한 전문가)\n조용하면서 논리적이고 분석적인 성향. 이해력이 빠르고 직관력이 높으며 천재성이 있어 노력보다 탁월한 성과를 올린다. 지적인 호기심도 많은 편. 이기적이고 자기중심적인 면이 강해서 쉽게 사람들과 어울리지 못하며 다소 자존감이 낮은 편이어서 천재성이 있지만 겸손한 편이다.");}
	void result9(){
		System.out.println("9. 우울다혈(정말 인간적인 타입)\n	다혈우울과 비슷하게 감성적인 성향이 강하며 예술적인 면과 섬세한 면이 탁월하다. 하지만 가끔 자신을 너무 과소평가하며 한번 우울해지면 극심한 좌절감에 빠진다. 거부당하는 것에 민감하며 상처를 잘 받는 편.");}
	void result10(){
		System.out.println("10. 점액우울(성실한 후원자)\n말없이 다정하고 온화하면서 내적인 신념이 강한 편으로 가장 친절하면서 조용한 성향. 화를 잘 내지 않고 적대감을 품지 않으며 신뢰감 있는 사람이다. 인내심이 강해 인내심이 있어야 하는 분야에서 성공하나 실천력이 없고 겁이 많고 소심해 과잉 참여를 두려워하는 성향이 있으며 자신이 만든 한계점을 절대 넘지 않으려 한다.");}
	void result11(){
		System.out.println("11. 점액다혈(인생의 굴곡이 없는 관계가 편안한 사람)\n가장 사람들과 원만하게 지낼 수 있는 타입. 모든 사람과 잘 어울리고 사려가 깊고 정이 많다. 믿을 만하면서도 유머 감각이 있어 남녀노소가 모두 좋아하며 평화로운 삶을 살면서도 가정적인 스타일. 그러나 게으르고 결단력과 자제력이 부족한 탓에 할 수 있음에도 도전이 싫어 좋은 기회를 놓칠 수 있다.");}
	void result12(){
		System.out.println("12. 점액담즙(잠재력이 뛰어난 사람)\n가장 활동적인 스타일이며 사람 관리에 탁월하다. 다른 사람의 말에 잘 귀 기울이며 온유한 마음이 있어 좋은 상담자가 될 수 있고 조직화된 곳에서는 제1의 전문가가 될 수 있는 잠재력이 있다. 고집이 좀 센 편이고 나이가 들수록 안주하려는 성향이 있어 소극적으로 될 수 있다.");}

	
}