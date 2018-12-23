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

public class WebOfStandard {
	
	static TextArea show = new TextArea("0");
	static StringBuilder a1 = new StringBuilder();
	static String[] ctype = { "标准计算器", "科学计算器" };
	int indexOf = 0; 
	int i = -1;
	double[] my = new double[10];
	static boolean restart = false;
	
		public BorderPane getScene() {
			// 整体的布局pane10：BorderPane
			BorderPane pane10 = new BorderPane();
			
			// 布局pane0：HBox
			HBox pane0 = new HBox(20);
			
			ComboBox<String> cbo = new ComboBox<>();
			ObservableList<String> items = FXCollections.observableArrayList(ctype);
			
			Text tittle2 = new Text("倔强长颈鹿：标准鹿");
			
			cbo.getItems().addAll(items);
			cbo.setValue("标准计算器");
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
			show.setFont(Font.font(25));
			show.setDisable(false);

			button1 btMc = new button1("MC");
			button1 btMr = new button1("MR");
			button1 btMa = new button1("M+");
			button1 btMm = new button1("M-");
			button1 btMs = new button1("MS");
			button1 btMf = new button1("Mˇ");

			
			paneone.setHgap(2.5);
			paneone.setVgap(2.5);
			paneone.addRow(1, btMc, btMr, btMa, btMm, btMs, btMf);

			pane1.setTop(show);
			pane1.setCenter(paneone);

			// 布局pane2:GridPane
			GridPane pane3 = new GridPane();
			
			button2 btPn = new button2("%");
			button2 btSr = new button2("√");
			button2 btSe = new button2("x^2");
			button2 btBm = new button2("1/x");
			
			button2 btCe = new button2("CE");
			button2 btC = new button2("C");
			button2 btDe = new button2("☒");
			button2 btAt = new button2("÷");
			
			button2 bt7 = new button2("7");
			button2 bt8 = new button2("8");
			button2 bt9 = new button2("9");
			button2 btTe = new button2("×");
			
			button2 bt4 = new button2("4");
			button2 bt5 = new button2("5");
			button2 bt6 = new button2("6");
			button2 btM = new button2("-");
			
			button2 bt1 = new button2("1");
			button2 bt2 = new button2("2");
			button2 bt3 = new button2("3");
			button2 btAd = new button2("+");
			
			button2 btOt = new button2("±");
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
				if(pane10.getCenter() == pane3) {
					pane10.setCenter(lv);	
				}else {
					pane10.setCenter(pane3);
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

			// 按钮显示
			bt0.setOnAction(e -> {
				if(show.getText().length() == 1 && show.getText().charAt(0) == '0') {
					show.setText("0");
				}else
					show.appendText("0");
				if(WebOfStandard.restart) {
					if(!Action.isSet(show.getText())) {
						show.setText("0");
					}
					WebOfStandard.restart = false;
				}
			});
			bt1.setOnAction(e -> {
				if(show.getText().length() == 1 && show.getText().charAt(0) == '0') {
					show.setText("1");
				}else
					show.appendText("1");
				if(WebOfStandard.restart) {
					if(!Action.isSet(show.getText())) {
						show.setText("1");
					}
					WebOfStandard.restart = false;
				}
			});
			bt2.setOnAction(e -> {
				if(show.getText().length() == 1 && show.getText().charAt(0) == '0') {
					show.setText("2");
				}else
					show.appendText("2");
				if(WebOfStandard.restart) {
					if(!Action.isSet(show.getText())) {
						show.setText("2");
					}
					WebOfStandard.restart = false;
				}
			});
			bt3.setOnAction(e -> {
				if(show.getText().length() == 1 && show.getText().charAt(0) == '0') {
					show.setText("3");
				}else
					show.appendText("3");
				if(WebOfStandard.restart) {
					if(!Action.isSet(show.getText())) {
						show.setText("3");
					}
					WebOfStandard.restart = false;
				}
			});
			bt4.setOnAction(e -> {
				if(show.getText().length() == 1 && show.getText().charAt(0) == '0') {
					show.setText("4");
				}else
					show.appendText("4");
				if(WebOfStandard.restart) {
					if(!Action.isSet(show.getText())) {
						show.setText("4");
					}
					WebOfStandard.restart = false;
				}
			});
			bt5.setOnAction(e -> {
				if(show.getText().length() == 1 && show.getText().charAt(0) == '0') {
					show.setText("5");
				}else
					show.appendText("5");
				if(WebOfStandard.restart) {
					if(!Action.isSet(show.getText())) {
						show.setText("5");
					}
					WebOfStandard.restart = false;
				}
			});
			bt6.setOnAction(e -> {
				if(show.getText().length() == 1 && show.getText().charAt(0) == '0') {
					show.setText("6");
				}else
					show.appendText("6");
				if(WebOfStandard.restart) {
					if(!Action.isSet(show.getText())) {
						show.setText("6");
					}
					WebOfStandard.restart = false;
				}
			});
			bt7.setOnAction(e -> {
				if(show.getText().length() == 1 && show.getText().charAt(0) == '0') {
					show.setText("7");
				}else
					show.appendText("7");
				if(WebOfStandard.restart) {
					if(!Action.isSet(show.getText())) {
						show.setText("7");
					}
					WebOfStandard.restart = false;
				}
			});
			bt8.setOnAction(e -> {
				if(show.getText().length() == 1 && show.getText().charAt(0) == '0') {
					show.setText("8");
				}else
					show.appendText("8");
				if(WebOfStandard.restart) {
					if(!Action.isSet(show.getText())) {
						show.setText("8");
					}
					WebOfStandard.restart = false;
				}
			});
			bt9.setOnAction(e -> {
				if(show.getText().length() == 1 && show.getText().charAt(0) == '0') {
					show.setText("9");
				}else
					show.appendText("9");
				if(WebOfStandard.restart) {
					if(!Action.isSet(show.getText())) {
						show.setText("9");
					}
					WebOfStandard.restart = false;
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
			btSr.setOnAction(e -> {
				if (Action.getF(show.getText()) == -1) {
					show.insertText(0, "√");
				} else {
					show.insertText(Action.getF(show.getText()), "√");
				}
			});
			btSe.setOnAction(e -> {
				if (Action.getF(show.getText()) == -1) {
					show.insertText(0, "sqr");
				} else {
					show.insertText(Action.getF(show.getText()), "sqr");
				}
			});
			btBm.setOnAction(e -> {
				if (Action.getF(show.getText()) == -1) {
					show.insertText(0, "1/");
				} else {
					show.insertText(Action.getF(show.getText()), "1/");
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
			
			btPn.setOnAction(e -> {
				show.appendText("%");
				String temp = show.getText();
				int a = temp.indexOf('%');
				while(a != 0) {
					if(temp.charAt(a) == '+' || temp.charAt(a) == '-' || temp.charAt(a) == '×' || temp.charAt(a) == '÷') {
						break;
					}
					a--;
				}
				if(a == 0) {
					show.setText("0");
				}else {
					show.setText(Action.dt("%", temp));
				}
				
			});
			
			btEt.setOnAction(e -> {
				show.setText(Action.firstD(show.getText()));
				WebOfStandard.restart = true;
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
				}catch (Exception a) {
					show.setText("0");
				}
			});

			if(restart) {
				int len = show.getText().length();
				char next = show.getText().charAt(len+1);
				if(next != '1' && next != '1' && next != '2' && next != '3' && next != '4' && next != '5' && next != '6' && next != '7' && next != '8' && next != '9' && next != '0' ) {
					restart = false;
				}
			}
			
			pane3.setHgap(2.5);
			pane3.setVgap(2.5);
			pane3.addRow(1,	btPn, btSr,btSe, btBm);
			pane3.addRow(2, btCe, btC, btDe, btAt);
			pane3.addRow(3, bt7, bt8, bt9, btTe);
			pane3.addRow(4, bt4, bt5, bt6, btM);
			pane3.addRow(5, bt1, bt2, bt3, btAd);
			pane3.addRow(6, btOt,bt0, btPt, btEt);
			
			VBox pane01 = new VBox();
			pane01.getChildren().add(pane0);
			pane01.getChildren().add(pane1);

			pane10.setPadding(new Insets(5, 5, 5, 5));
			
			pane10.setTop(pane01);
			pane10.setCenter(pane3);
			
			BorderPane web2 = new BorderPane();
			web2.setCenter(pane10);
			
			cbo.setOnAction(e ->{
				indexOf = items.indexOf(cbo.getValue());
				if(indexOf == 1) {
					WebOfScience web1 = new WebOfScience();
					web2.setCenter(web1.getScene());
				}
			});
			return web2;
		}
	
	// 按钮类型1
	class button1 extends Button {
		button1() {
			super();
			super.setPrefSize(45, 25);
		}

		button1(String text) {
			super(text);
			super.setPrefSize(45, 25);
		}
	}

	// 按钮类型2
	class button2 extends Button {
		button2() {
			super();
			super.setPrefSize(80, 50);
		}

		button2(String text) {
			super(text);
			super.setPrefSize(80, 50);
		}
	}
}
