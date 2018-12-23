package calculater;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class WebOfScience {
	
	static TextArea show = new TextArea("0");
	static StringBuilder a1 = new StringBuilder();
	static String[] ctype = { "标准计算器", "科学计算器" };
	int indexOf = 0; 
	int i = -1;
	double [] my = new double[50];
	static boolean restart = false;
	static boolean isFe = false;
	static boolean isHyp = false;
	static int rep = -1;
	
		public BorderPane getScene() {
			// 整体的布局：VBox
			BorderPane pane10 = new BorderPane();
			
			// 布局pane0：HBox
			HBox pane0 = new HBox(20);
			
			ComboBox<String> cbo = new ComboBox<>();
			ObservableList<String> items = FXCollections.observableArrayList(ctype);
			
			Text tittle2 = new Text("倔强长颈鹿：高数鹿");
			
			cbo.getItems().addAll(items);
			cbo.setValue("科学计算器");
			cbo.setPrefWidth(150);
			
			pane0.setAlignment(Pos.CENTER_LEFT);
			pane0.setPadding(new Insets(10, 10, 10, 10));

			pane0.getChildren().addAll(cbo, tittle2);

			new Button();

			// 布局pane1:BorderPane
			BorderPane pane1 = new BorderPane();
			GridPane paneone = new GridPane();

			show.setPrefRowCount(1);
			show.setPrefWidth(300);
			show.setFont(Font.font(18));
			show.setDisable(false);

			button1 btDeg = new button1("Deg");
			button1 btHyp = new button1("HYP");
			button1 btFe = new button1("F-E");
			button1 btMc = new button1("MC");
			button1 btMr = new button1("MR");
			button1 btMa = new button1("M+");
			button1 btMm = new button1("M-");
			button1 btMs = new button1("MS");
			button1 btMf = new button1("Mˇ");

			paneone.setHgap(5);
			paneone.setVgap(2.5);
			paneone.addRow(1, btDeg, btHyp, btFe);
			paneone.addRow(2, btMc, btMr, btMa, btMm, btMs, btMf);

			pane1.setTop(show);
			pane1.setCenter(paneone);

			// 布局pane2:GridPane
			GridPane pane21 = new GridPane();
			GridPane pane22 = new GridPane();
			GridPane pane3 = new GridPane();
			
			button2 btSe = new button2("x^2");
			button2 btPf = new button2("x^y");
			button2 btSin = new button2("sin");
			button2 btCos = new button2("cos");
			button2 btTan = new button2("tan");

			button2 btSr = new button2("√");
			button2 btTx = new button2("10^x");
			button2 btLog = new button2("log");
			button2 btExp = new button2("Exp");
			button2 btMod = new button2("Mod");
			
			button2 btCb = new button2("x^3");
			button2 btPb = new button2("y√x");
			button2 btBsin = new button2("sin-1");
			button2 btBcos = new button2("cos-1");
			button2 btBtan = new button2("tan-1");
			button2 btBm = new button2("1/x");
			button2 btEc = new button2("e^x");
			button2 btLn = new button2("ln");
			button2 btDms = new button2("dms");
			button2 btSdeg = new button2("deg");
			
			button2 btUp = new button2("↑");
			button2 btCe = new button2("CE");
			button2 btC = new button2("C");
			button2 btDe = new button2("☒");
			button2 btAt = new button2("÷");

			button2 btPi = new button2("π");
			button2 bt7 = new button2("7");
			button2 bt8 = new button2("8");
			button2 bt9 = new button2("9");
			button2 btTe = new button2("×");

			button2 btFl = new button2("n!");
			button2 bt4 = new button2("4");
			button2 bt5 = new button2("5");
			button2 bt6 = new button2("6");
			button2 btM = new button2("-");

			button2 btOt = new button2("±");
			button2 bt1 = new button2("1");
			button2 bt2 = new button2("2");
			button2 bt3 = new button2("3");
			button2 btAd = new button2("+");

			button2 btLp = new button2("(");
			button2 btRp = new button2(")");
			button2 bt0 = new button2("0");
			button2 btPt = new button2(".");
			button2 btEt = new button2("=");

			//存储
			btMs.setOnAction(e -> {
				try {
					i++;
					my[i] = Double.valueOf(show.getText());
				}catch(Exception p) {}
			});
			btMa.setOnAction(e -> {
				try {
					if(i == -1) {
						i++;
					}
					my[i] += Double.valueOf(show.getText()); 
				}catch(Exception p) {}
			});
			btMm.setOnAction(e -> {
				try {
					if(i == -1) {
						i++;
					}
					my[i] -= Double.valueOf(show.getText()); 
				}catch(Exception p) {}
				
			});
			btMf.setOnAction(e -> {
					String[] mf = new String[i+1];
					for(int j = 0; j < i+1; j++ ) {
						mf[j] = String.valueOf(my[j]);	
					}
					ListView<String> lv = new ListView<>(FXCollections.observableArrayList(mf));
					if(pane10.getCenter() == pane21 || pane10.getCenter() == pane22) {
						pane10.setCenter(lv);	
					}else {
						pane10.setCenter(pane21);
					}				
			});
			btMc.setOnAction(e -> {
				try {
					my = new double[10];
					i = -1;
				}catch(Exception p) {}
				
			});
			btMr.setOnAction(e -> {
				try {
					show.setText(String.valueOf(my[i]));	
				}catch (Exception a) {
					show.setText("0");
				}
			});
			
			//顶3个键
			btFe.setOnAction(e -> {
				if(!Action.isSet(show.getText()) && isFe == false) {
					show.setText(Action.getFe(show.getText()));
				}else {
					show.setText(Action.handle(show.getText()));
				}
				if(isFe) {
					isFe = false;
				}else {
					isFe = true;
				}
			});
			btHyp.setOnAction(e -> {
				if(isHyp) {//回去
					if(pane10.getCenter() == pane21) {
						btSin.setText("sin");
						btCos.setText("cos");
						btTan.setText("tan");
					}else {
						btBsin.setText("sin^-1");
						btBcos.setText("cos^-1");
						btBtan.setText("tan^-1");
					}
					isHyp = false;
				}else {//覆盖新的名称
					if(pane10.getCenter() == pane21) {
						btSin.setText("sinh");
						btCos.setText("cosh");
						btTan.setText("tanh");
					}else {
						btBsin.setText("sinh");
						btBcos.setText("cosh");
						btBtan.setText("tanh");
					}
					isHyp = true;
				}
			});
			btDeg.setOnAction(e -> {
				if(rep == -1) {
					btDeg.setText("RAD");
					rep = 0 ;//0
				}else if(rep == 0) {
					btDeg.setText("GRAD");
					rep = 1;//1
				}else if(rep == 1) {
					btDeg.setText("DEG");
					rep = -1;//-1
				}
				
			});
			// 按钮显示
			bt0.setOnAction(e -> {
				if(show.getText().length() == 1 && show.getText().charAt(0) == '0') {
					show.setText("0");
				}else
					show.appendText("0");
				if(WebOfScience.restart) {
					if(!Action.isSet(show.getText())) {
						show.setText("0");
					}
					WebOfScience.restart = false;
				}
			});
			bt1.setOnAction(e -> {
				if(show.getText().length() == 1 && show.getText().charAt(0) == '0') {
					show.setText("1");
				}else
					show.appendText("1");
				if(WebOfScience.restart) {
					if(!Action.isSet(show.getText())) {
						show.setText("1");
					}
					WebOfScience.restart = false;
				}
			});
			bt2.setOnAction(e -> {
				if(show.getText().length() == 1 && show.getText().charAt(0) == '0') {
					show.setText("2");
				}else
					show.appendText("2");
				if(WebOfScience.restart) {
					if(!Action.isSet(show.getText())) {
						show.setText("2");
					}
					WebOfScience.restart = false;
				}
			});
			bt3.setOnAction(e -> {
				if(show.getText().length() == 1 && show.getText().charAt(0) == '0') {
					show.setText("3");
				}else
					show.appendText("3");
				if(WebOfScience.restart) {
					if(!Action.isSet(show.getText())) {
						show.setText("3");
					}
					WebOfScience.restart = false;
				}
			});
			bt4.setOnAction(e -> {
				if(show.getText().length() == 1 && show.getText().charAt(0) == '0') {
					show.setText("4");
				}else
					show.appendText("4");
				if(WebOfScience.restart) {
					if(!Action.isSet(show.getText())) {
						show.setText("4");
					}
					WebOfScience.restart = false;
				}
			});
			bt5.setOnAction(e -> {
				if(show.getText().length() == 1 && show.getText().charAt(0) == '0') {
					show.setText("5");
				}else
					show.appendText("5");
				if(WebOfScience.restart) {
					if(!Action.isSet(show.getText())) {
						show.setText("5");
					}
					WebOfScience.restart = false;
				}
			});
			bt6.setOnAction(e -> {
				if(show.getText().length() == 1 && show.getText().charAt(0) == '0') {
					show.setText("6");
				}else
					show.appendText("6");
				if(WebOfScience.restart) {
					if(!Action.isSet(show.getText())) {
						show.setText("6");
					}
					WebOfScience.restart = false;
				}
			});
			bt7.setOnAction(e -> {
				if(show.getText().length() == 1 && show.getText().charAt(0) == '0') {
					show.setText("7");
				}else
					show.appendText("7");
				if(WebOfScience.restart) {
					if(!Action.isSet(show.getText())) {
						show.setText("7");
					}
					WebOfScience.restart = false;
				}
			});
			bt8.setOnAction(e -> {
				if(show.getText().length() == 1 && show.getText().charAt(0) == '0') {
					show.setText("8");
				}else
					show.appendText("8");
				if(WebOfScience.restart) {
					if(!Action.isSet(show.getText())) {
						show.setText("8");
					}
					WebOfScience.restart = false;
				}
			});
			bt9.setOnAction(e -> {
				if(show.getText().length() == 1 && show.getText().charAt(0) == '0') {
					show.setText("9");
				}else
					show.appendText("9");
				if(WebOfScience.restart) {
					if(!Action.isSet(show.getText())) {
						show.setText("9");
					}
					WebOfScience.restart = false;
				}
			});
			btPt.setOnAction(e -> {
				show.appendText(".");
			});
			btAd.setOnAction(e -> {
				show.appendText("+");
			});
			btM.setOnAction(e -> {
				if(show.getText().length() == 1 && show.getText().charAt(0) == '0') {
					show.setText("-");
				}else
					show.appendText("-");
			});
			btTe.setOnAction(e -> {
				show.appendText("×");
			});
			btAt.setOnAction(e -> {
				show.appendText("÷");
			});
			btFl.setOnAction(e -> {
				show.appendText("!");
			});
			btSr.setOnAction(e -> {
				if (Action.getF(show.getText()) == -1) {
					show.insertText(0, "√");
				} else {
					show.insertText(Action.getF(show.getText()), "√");
				}
			});
			btTx.setOnAction(e -> {
				if (Action.getF(show.getText()) == -1) {
					show.insertText(0, "10^");
				} else {
					show.insertText(Action.getF(show.getText()), "10^");
				}
			});
			btLog.setOnAction(e -> {
				if (Action.getF(show.getText()) == -1) {
					show.insertText(0, "log");
				} else {
					show.insertText(Action.getF(show.getText()), "log");
				}
			});
			btExp.setOnAction(e -> {
				show.appendText("E");
			});
			btMod.setOnAction(e -> {
				show.appendText("Mod");
			});
			btSe.setOnAction(e -> {
				if (Action.getF(show.getText()) == -1) {
					show.insertText(0, "sqr");
				} else {
					show.insertText(Action.getF(show.getText()), "sqr");
				}
			});
			btCb.setOnAction(e -> {
				if (Action.getF(show.getText()) == -1) {
					show.insertText(0, "cube");
				} else {
					show.insertText(Action.getF(show.getText()), "cube");
				}
			});
			btPb.setOnAction(e -> {
				show.appendText("yroot");
			});
			btBsin.setOnAction(e -> {
				if (Action.getF(show.getText()) == -1) {
					show.insertText(0, btBsin.getText());
				} else {
					show.insertText(Action.getF(show.getText()), btBsin.getText());
				}
			});
			btBcos.setOnAction(e -> {
				if (Action.getF(show.getText()) == -1) {
					show.insertText(0, btBcos.getText());
				} else {
					show.insertText(Action.getF(show.getText()), btBcos.getText());
				}
			});
			btBtan.setOnAction(e -> {
				if (Action.getF(show.getText()) == -1) {
					show.insertText(0, btBtan.getText());
				} else {
					show.insertText(Action.getF(show.getText()), btBtan.getText());
				}
			});
			btBm.setOnAction(e -> {
				if (Action.getF(show.getText()) == -1) {
					show.insertText(0, "1/");
				} else {
					show.insertText(Action.getF(show.getText()), "1/");
				}
			});
			btEc.setOnAction(e -> {
				if (Action.getF(show.getText()) == -1) {
					show.insertText(0, "e^");
				} else {
					show.insertText(Action.getF(show.getText()), "5^");
				}
			});
			btLn.setOnAction(e -> {
				if (Action.getF(show.getText()) == -1) {
					show.insertText(0, "ln");
				} else {
					show.insertText(Action.getF(show.getText()), "ln");
				}
			});
			btDms.setOnAction(e -> {
				if (Action.getF(show.getText()) == -1) {
					show.insertText(0, "dms");
				} else {
					show.insertText(Action.getF(show.getText()), "dms");
				}
			});
			btSdeg.setOnAction(e -> {
				if (Action.getF(show.getText()) == -1) {
					show.insertText(0, "degrees");
				} else {
					show.insertText(Action.getF(show.getText()), "degress");
				}
			});
			btPf.setOnAction(e -> {
				show.appendText("^");
			});
			btSin.setOnAction(e -> {
				if (Action.getF(show.getText()) == -1) {
					show.insertText(0, btSin.getText());
				} else {
					show.insertText(Action.getF(show.getText()), btSin.getText());
				}
			});
			btCos.setOnAction(e -> {
				if (Action.getF(show.getText()) == -1) {
					show.insertText(0, btCos.getText());
				} else {
					show.insertText(Action.getF(show.getText()), btCos.getText());
				}
			});
			btTan.setOnAction(e -> {
				if (Action.getF(show.getText()) == -1) {
					show.insertText(0, btTan.getText());
				} else {
					show.insertText(Action.getF(show.getText()), btTan.getText());
				}
			});
			btOt.setOnAction(e -> {
				if (Action.getF(show.getText()) == -1) {

					show.insertText(0, "-");
				} else {
					char c = show.getText().charAt(Action.getF(show.getText()) - 1);
					if (c == '-') {
						a1.append(show.getText());
						a1.replace(Action.getF(show.getText()) - 1, Action.getF(show.getText()), "+");
						show.setText(a1.toString());
						a1.delete(0, a1.length());
					} else if (c == '+') {
						a1.append(show.getText());
						a1.replace(Action.getF(show.getText()) - 1, Action.getF(show.getText()), "-");
						show.setText(a1.toString());
						a1.delete(0, a1.length());
					} else
						show.insertText(Action.getF(show.getText()), "-");
				}

			});
			btEt.setOnAction(e -> {
				show.setText(Action.firstD(show.getText()));
				WebOfScience.restart = true;
			});

			btDe.setOnAction(e -> {
					if(show.getLength() >= 2) {
						show.deleteText(show.getLength() - 1, show.getLength());	
					}else {
						show.setText("0");
					}
			});
			btC.setOnAction(e -> {
				show.setText("0");
			});
			btCe.setOnAction(e -> {
				try {
					if (Action.getF(show.getText()) == -1) {
						show.setText("0");
					} else
						show.deleteText(Action.getF(show.getText()), show.getText().length());
				}catch (Exception i) {
					show.setText("0");
				}
			});
			btUp.setOnAction(e -> {
				if(pane10.getCenter() == pane21) {
					pane10.setCenter(pane22);
				}
				else {
					pane10.setCenter(pane21);
				}
				
			});
			btPi.setOnAction(e -> {
				if(show.getText().length() == 1 && show.getText().charAt(0) == '0') {
					show.setText("3.141592");
				}else
					show.appendText("3.141592");
				if(WebOfScience.restart) {
					if(!Action.isSet(show.getText())) {
						show.setText("3.141592");
					}
					WebOfScience.restart = false;
				}
			});
			btLp.setOnAction(e -> {
				if(show.getText().length() == 1 && show.getText().charAt(0) == '0') {
					show.setText("(");
				}else
					show.appendText("(");
				if(WebOfScience.restart) {
					if(!Action.isSet(show.getText())) {
						show.setText("(");
					}
					WebOfScience.restart = false;
				}
			});
			btRp.setOnAction(e -> {
				show.appendText(")");
			});

			pane21.setHgap(2.5);
			pane21.setVgap(2.5);
			pane21.addRow(1, btSe, btPf, btSin, btCos, btTan);
			pane21.addRow(2, btSr, btTx, btLog, btExp, btMod);
			
			pane22.setHgap(2.5);
			pane22.setVgap(2.5);
			pane22.addRow(1, btCb, btPb, btBsin, btBcos, btBtan);
			pane22.addRow(2, btBm, btEc, btLn, btDms, btSdeg);
			
			pane3.setHgap(2.5);
			pane3.setVgap(2.5);
			pane3.addRow(3, btUp, btCe, btC, btDe, btAt);
			pane3.addRow(4, btPi, bt7, bt8, bt9, btTe);
			pane3.addRow(5, btFl, bt4, bt5, bt6, btM);
			pane3.addRow(6, btOt, bt1, bt2, bt3, btAd);
			pane3.addRow(7, btLp, btRp, bt0, btPt, btEt);
			
			VBox pane01 = new VBox();
			pane01.getChildren().add(pane0);
			pane01.getChildren().add(pane1);

			
			pane10.setPadding(new Insets(5, 5, 5, 5));
			pane10.setTop(pane01);
			pane10.setCenter(pane21);
			pane10.setBottom(pane3);
			
			BorderPane web1 = new BorderPane();
			web1.setCenter(pane10);
			
			cbo.setOnAction(e ->{
				indexOf = items.indexOf(cbo.getValue());
				if(indexOf == 0) {
					WebOfStandard web2 = new WebOfStandard();
					web1.setCenter(web2.getScene());
				}
			});
			return web1;
		}

	// 按钮类型1
	class button1 extends Button {
		button1() {
			super();
			super.setPrefSize(45, 30);
		}

		button1(String text) {
			super(text);
			super.setPrefSize(45, 30);
		}
	}

	// 按钮类型2
	class button2 extends Button {
		button2() {
			super();
			super.setPrefSize(60, 30);
		}

		button2(String text) {
			super(text);
			super.setPrefSize(60, 30);
		}
	}
}
