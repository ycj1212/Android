# **Android**


---
## **4. 사용자 인터페이스 기초**
- 사용자 인터페이스(UI : User Interface)
	- 뷰 : 사용자 인터페이스를 구성하는 기초적인 빌딩 블록
		- View 클래스를 상속받아서 작성된다.
		- **컨트롤** 또는 **위젯**이라고 불린다.
	- 뷰그룹 : 다른 뷰들을 담는 컨테이너 기능을 한다.
		- ViewGroup 클래스에서 상속받아 작성된다.
		- 흔히 **레이아웃**이라고 불린다.
	- UI를 작성하는 방법 : 뷰그룹을 먼저 생성하고 필요한 뷰들을 추가하면 된다.

- 사용자 인터페이스 작성 방법
	- XML로 작성
		- 코드와 화면 디자인을 분리할 수 있다. 코드는 프로그래머가, 화면 디자인은 디자이너가 담당할 수 있다.
		- 사용자 인터페이스가 코드의 외부에서 정의된다. 따라서 소스 코드를 변경하거나 재컴파일할 필요 없이 사용자 인터페이스를 변경할 수 있다.
		- 사용자 인터페이스는 언제든지 교체할 수 있어 빠르게 현지화할 수 있다.
		- 비주얼 도구를 이용하여서 사용자 인터페이스를 빠르게 작성할 수 있다.
		- 예제실습
		```
		
		```
	- 코드로 작성
		- 예제실습
		```

		```
		- 코드와 디자인이 분리되어 있지 않다.
		* 레이아웃 안에 다른 레이아웃을 넣을 수 있다. 즉, 컨테이너 안에 다른 컨테이너도 넣을 수 있다.

	- XML과 코드를 동시에 사용
		- 레이아웃을 처음에는 XML로 정의하고 실행 시간에 레이아웃에 포함된 뷰를 참조하여서 그 속성을 변경하는 방법
		- 예제실습

		```
        sadf
        ```

        `"@+id/button1"`
		
        - @는 리소스에서 참조한다는 의미
		- +는 새로 생성한다는 의미
		- id는 식별자를 나타내는 패키지 이름
		- button1이 식별자가 된다.

- 비주얼 도구를 이용하여 사용자 인터페이스 만들기
	- app\res\layout\main.xml 에서 design탭에서 원하는 컨트롤들을 화면에 드래그하여 배치
	- Component Tree 윈도우에는 뷰들의 계층 구조가 그려져있다.
	- Properties 창에서 속성을 변경할 수 있다.

- 뷰
	- View 클래스는 모든 뷰들의 부모 클래스이다.
	- id : 모든 뷰는 정수로 된 id를 가진다.

	    `android:id="@+id/my_button"`
	- 뷰의 위치와 크기
		- match_parent : 부모의 크기를 꽉 채운다(=fill_parent)
		- wrap_content : 뷰가 나타내는 내용물의 크기에 맞춘다.
		- 숫자 : 크기를 정확히 지정
		- 뷰의 실제 위치는 getLeft()와 getTop()으로 얻을 수 있고, 실제 너비와 높이는 getWidth()와 getHeight()로 얻을 수 있다.
	- 색상
	- 그리기
	- 마진과 패딩
		- 패딩 : 뷰와 콘텐츠와의 간격	ex) 버튼의 문자열과 버튼의 테두리와의 간격
			- paddingLeft, paddingRight, paddingTop, paddingBottom
			- setPadding(int, int, int, int) 메소드 사용
		- 마진 : 컨테이너와 뷰와의 간격
			- layout_marginLeft, layout_marginRight, layout_marginTop, layout_marginBottom
		- 예제
		```

		```

- 기초적인 뷰들
	- 텍스트 뷰

	- 에디트 텍스트

	- 이미지 뷰

	- 버튼

- LAB) 계산기 앱 작성
	- 

---
## **5. 레이아웃**
- 레이아웃
	- 레이아웃 클래스는 뷰들의 위치와 크기를 결정합니다.
	- ViewGroup 클래스로부터 상속 받는다.
	- LinearLayout
	- TableLayout
	- GridLayout
	- RelativeLayout
	- TabLayout
	- AbsoluteLayout
	- FrameLayout

- 선형 레이아웃(LinearLayout)
	- 수평 배치

	    `android:orientation="horizontal"`
	- 수직 배치

	    `android:orientation="vertical"`
	- Gravity 속성

	    `android:gravity="center"`

	- 베이스라인 정렬

        `android:baselineAligned="true"`

	- 가중치

	    `android:layout_weight="1"`

- 프레임 레이아웃(FrameLayout)
	- 여러 개의 뷰가 겹쳐져서 표시된다.
	- 프레임 레이아웃에서는 자식뷰들이 추가된 순서대로 쌓이게 된다.
	- 뷰의 가시성 제어

	    `android:visibility="visible"`

	    `android:visibility="invisible"`

- 테이블 레이아웃(TableLayout)
	- 자식 뷰들을 테이블 형태로 배치
	- 하나의 테이블은 여러 개의 TableRow 객체로 이루어지고, 하나의 TableRow 안에는 여러 개의 셀들이 들어간다.
	- 하나의 셀 안에는 하나의 뷰 객체가 들어간다.
	- 셀들의 경계선을 그리지 않는다.
	
- 상대적 레이아웃(RelativeLayout)
	- 말 그대로 상대적으로 배치됨

- 절대적 레이아웃(AbsoluteLayout)
	- 절대적인 좌표값을 주어서 뷰들을 배치하는 방법이다.
	- 사용하기 매우 쉬운 방법이지만 장치들의 화면 크기가 제각각이기 때문에 많이 사용되지는 않는다.

- 코드로 레이아웃 변경하기
	- XML로 생성하고 코드로 속성 변경하기
	- 예제실습
	```

	```
	- findViewById() 메소드는 ID에 해당하는 뷰를 찾아서 반환한다.

- 코드로 레이아웃 객체 생성하기
	- 예제실습
	```

	```
	- 사용자 인터페이스가 변경되려면 반드시 코드를 변경해야 하는 단점이 있다.
	- 따라서 특수한 경우에만 사용...

- LAB) 계산기 앱 작성


---
## **6. 입력 위젯과 이벤트 처리**
- 입력 위젯
	- 위젯 - 그래픽 사용자 인터페이스를 이루는 부품??

- 버튼
	- 텍스트 버튼
		- Button 클래스를 이용

		`android:text="@string/button_text"`

	- 이미지 버튼
		- ImageButton 클래스를 이용
		
		`android:src="@drawable/button_icon"` <- 이미지 파일 이름

	- 텍스트와 이미지를 동시에 가지는 버튼
		
		`android:text="@string/button_text"`
		`android:drawableLeft="@drawable/button_icon"`

	- 버튼의 이벤트 처리
		- 클릭 이벤트가 발생하면 레이아웃에 등록된 메소드가 자동으로 호출된다.
		- onClick 속성을 추가

		`android:onClick="onClick"`	<- 이벤트를 처리하는 메소드 이름
		
		`public void onClick(View view){ ··· }` <- XML 파일에 적었던 메소드를 구현

	- 예제 : 이미지 버튼 만들기
	```

	```

	- 예제 : 커스텀 버튼
	```

	```
	
- 이벤트를 처리하는 방법
	- XML 파일에 이벤트 처리 메소드를 등록하는 방법
		- 클릭 이벤트만을 처리할 수 있는 방법
		- 버튼과 같은 위젯의 경우, 가장 간단하게 이벤트를 처리할 수 있다.
	- 이벤트를 처리하는 객체를 생성하여 이벤트를 처리하는 방법
		- 이벤트를 처리하는 객체를 별도로 생성하여 위젯에 등록
		- 이벤트를 처리하는 가장 일반적인 방법
	- 뷰 클래스의 이벤트 처리 메소드를 재정의하는 방법
		- 커스텀 뷰를 작성하는 경우에만 사용할 수 있는 방법

- 이벤트 처리 객체를 이용하여 이벤트 처리하기
	- 이벤트를 처리하는 메소드들이 정의된 인터페이스를 **이벤트 리스너**라고 부른다.
	```
	class MyClass{
		// 리스너 인터페이스를 구현한 클래스 정의
		class Listener implements OnClickListener{
			public void onClick(View v){
				...
			}
		}

		Listener lis = new Listener();	// 이벤트 리스너 객체 생성
		button.setOnClickListener(lis);	// 버튼에 이벤트 리스너 객체를 등록
	}
	```
	- 무명 클래스를 사용하여서 이벤트를 처리하는 방법
	```
	Button button = (Button) findViewById(R.id.button_send);
	button.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			// 버튼이 클릭되면 여기서 어떤 작업을 한다.
		}
	});
	```

	- 리스너 객체를 생성하는 방법
		- 리스너 클래스를 **내부 클래스**로 정의한다.
		- 리스너 클래스를 **무명 클래스**로 정의한다.
		- 리스너 인터페이스를 **액티비티 클래스**에 구현한다.

	- 내부 클래스로 처리하는 방법
		- 내부 클래스는 자신이 속해있는 클래스의 멤버들에 자유롭게 접근하여 사용할 수 있다는 큰 장점이 있다.

	```
	- Toast 기능
	Toast는 뷰의 일종으로 화면에 잠깐 나타나는 메시지를 표시할 때 사용된다.
	사용자에게 방해가 되지 않으면서 어떤 정보를 표시할 목적으로 작성되었다.
	일반적으로 정적 메소드인 makeText()를 호출하여 토스트 객체를 생성하고
	show() 메소드를 호출하여서 메시지를 표시한다.
	```
	
	- 무명 클래스로 처리하는 방법

	- 액티비티에 인터페이스를 구현하는 방법

- 텍스트 필드
	- 텍스트 필드를 사용하면 사용자가 앱에 텍스트를 타이핑하여 입력할 수 있다.

- 체크 박스
	- 체크 박스는 사용자가 하나의 그룹 안에서 여러 개를 동시에 선택할 때 사용하는 위젯이다.
	```

	```

- 라디오 버튼
	- 라디오 버튼은 하나의 그룹 안에서는 한 개의 버튼만 선택할 수 있다.
	```

	```

- 토글 버튼
	- 두 가지의 상태 중의 하나로 토글되도록 만들어진 버튼
	```

	```
	
- 레이팅 바
	- 레이팅 바는 별 모양을 이용하여서 점수를 주는 경우에 사용되는 위젯
	```

	```
	
- 커스텀 컴포넌트
	- 개발자가 직접 View 클래스를 상속받아서 필요한 위젯을 개발할 수 있다.
	```

	```



---
## **5. 메뉴와 대화상자**
- 사용자 인터페이스 개요
	- 네비게이션 바
	- 액션바
	- 다중 패널 레이아웃
	- 앱의 외관 커스텀화
	- 터치 피드백
	- 제스처
		- 터치
		- 오래 누르기
		- 드래그, 스와이프
		- 더블터치
		- 오래 누르면서 드래그
		- 더블 터치 드래그
		- 핀치 열기, 닫기

- 메뉴
	- 옵션 메뉴 : MENU 버튼을 누르면 나타는 메뉴
	- 컨텍스트 메뉴 : 요소를 길게 누르면 나타는 메뉴
	- 팝업 메뉴 : 특정한 뷰에 붙어서 나타나는 수직방향의 리스트
	
- XML로 메뉴 정의하기
	- 메뉴 구조를 쉽게 시각화할 수 있다.
	- 코드와 메뉴가 분리되어서 차후에 쉽게 변경할 수 있다.
	- 플랫폼 버전이나 화면 크기에 따라서 서로 다른 메뉴 구성을 가질 수 있다.
	```

	```

- 옵션 메뉴 생성하기
	- 옵션 메뉴는 현재 액티비티와 관련된 여러 가지 동작이나 선택사항을 설정하는 메뉴이다.
	```
	@Override
	// 액티비티의 메소드 onCreateOptionMenu()를 재정의한다.
	public boolean onCreateOptionMenu(Menu menu){
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.mymenu, menu);		// 메뉴 리소스 팽창
		return true;
	}
	```
	- 메뉴 팽창(inflate)
		- 메뉴 리소스를 팽창하면 실제 메뉴가 생성된다.
		- 팽창한다는 의미는 프로그래밍 객체로 변환한다는 뜻이다.

	- 클릭 이벤트 처리
	```

	```

	- 코드로 옵션 메뉴 생성하기

- 컨텍스트 메뉴
	- 플로팅 컨텍스트 메뉴 : 항목 위에 오래누르기를 하면 메뉴가 표시됨
	- 컨텍스트 액션 메뉴 : 선택된 항목에 관련된 메뉴가 액션바에 표시됨

- 팝업 메뉴
	- 특정한 뷰에 붙어있는 메뉴

- 대화 상자
	- 사용자에게 메시지를 출력하고 사용자로부터 입력을 받아들이는 사용자 인터페이스
	- AlertDialog

- DatePickerDialog


- 커스텀 대화 상자

- 알림기능
	- 알림을 만드는 절차
		1. 알림 빌더를 생성한다.
		```
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		```
		2. 알림 속성을 설정한다.
		```
		builder.setSmallIcon(R.drawable.notification_icon);
		builder.setContentTitle("알려드립니다.");
		builder.setContentText("이것은 시험적인 알림입니다.");
		```
		3. 액션을 첨부한다.
		```
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/"));
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
		builder.setContentIntent(pendingIntent);
		```
		4. 알림 생성
		```
		NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		notificationManager.notify(NOTIFICATION_ID, builder.build());
		```


---
## **6. 그래픽**
- 그래픽
	- 2차원 그래픽을 사용하는 방법
		1. 캔버스에 코드로 직접 그린다. onDraw() 메소드 안에 draw...()와 같은 메소드 호출
			- UI 액티비티와 같은 스레드 안에서 커스텀 뷰를 생성하고 invalidate()를 호출하여 화면을 그린다. invalidate()는 onDraw()를 호출한다.
			- 별도의 화면과 스레드를 생성하여서, UI 스레드와는 독립적으로 그래픽을 그린다.
		2. 레이아웃 파일 안에서 그래픽이나 애니메이션을 정의

- 커스텀 뷰를 사용하여 그리기
	```
	class MyView extends View {
		...
		protected void onDraw(Canvas canvas) {
			Paint paint = new Paint();
			// 여기에 그림을 그리는 코드 작성
		}
	}

	public class MainActivity extends AppCompatActivity {
		public void onCreate(Bundle is) {
			...
			MyView w = new MyView(this);
			setContentView(w);
			// MyView를 생성하고 이것을 Activity의 컨텐트 뷰로 설정
		}
	}
	```

	- Canvas 클래스
		- 그림을 그리는 캔버스에 해당되는 것으로 Bitmap 객체를 가지고 있다.
		- onDraw()에서는 캔버스가 주어지지만 우리가 새로운 캔버스를 생성할 수도 있는데 이 때는 비트맵도 함께 생성하여야 한다.
		```
		Bitmap b = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
		Canvas c = new Canvas(b);
		```

	* 그림이 그려지는 화포가 Canvas, 붓이나 물감이 Paint

	- Paint 클래스
		- Canvas의 메소드는 항상 Paint 객체를 마지막 매개변수로 하여 호출되어야 한다.

	- 커스텀 뷰를 XML 파일에서 참조하는 방법
	```
	
	```

- 그리기 속성
	- 색상
		- 색상은 색의 3원색인 Red, Green, Blue 성분을 8비트로 표시하여 나타낸다.
		- 따라서 24비트이면 하나의 색상을 표현할 수 있고, 24비트를 16진수로 표시하는 것이 일반적

		`paint.setColor(0xFF0000); // Red`

		`paint.setColor(Color.RED);`

	- 앤티 에일리어싱 : 도형의 경계부분을 더 매끄럽게 그려지도록 하는 기술

	- 폰트 변경
		- Typeface 클래스의 객체로 표현
		- 폰트 생성 Typeface.create()
		- 폰트 변경 setTypeface()
		- 설정된 폰트를 이용하여 화면에 그리려면 Paint 클래스의 drawText()
	```

	```

- 패스 그리기
	- 패스는 복잡한 기하학적인 경로를 표시한다.

- 이미지 표시하기
	- ImageView를 사용하는 방법
	
	- 이미지를 직접 그려주는 방법
	```
	Bitmap b = BitmapFactory.decodeResource(getResource(), R.drawable.android);
	( 이미지 데이터를 포함하는 애플리케이션 리소스 객체, 이미지의 리소스 식별자 )
	```
	- decodeResource()는 첫 번째 인수인 리소스 객체에서 두 번째 인수인 식별자에 해당하는 리소스를 찾고 디코딩하여 비트맵으로 변환한다.

	
	```
	void drawBitmap(Bitmap bitmap, float left, float top, Paint paint);
	(화면에 그릴 비트맵, 이미지가 그려지는 위치, 변환 행렬이 들어 있는 Paint 객체)
	* 여기서 이미지를 변환할 필요가 없다면 paint는 null로 주어도 된다.
	```

	- 비트맵의 확대 및 축소
	```
	Bitmap b = BitmapFactory.decodeResource(getResource(), R.drawable.android);
	Bitmap sb = Bitmap.createScaledBitmap(b, 60, 80, false);
	60*80 크기의 새로운 비트맵 생성
	```
	
	- 비트맵의 변환
		- 상하가 뒤집힌 비트맵 생성
		```
		Matrix m = new Matrix();	// 변환 행렬을 생성
		m.preScale(1, -1);	// x값에 1을 곱하고 y값에 -1을 곱하는 변환행렬을 만든다.		
		Bitmap b = BitmapFactory.decodeResource(getResource(), R.drawable.android);
		Bitmap mb = Bitmap.createBitmap(b, 0, 0, b.getWidth(), b.getHeight(), m, false);
		// 변환 행렬 m이 적용된 새로운 비트맵을 생성한다.
		```

- 도형 객체 이용하기
	- android.graphics.drawable 패키지에는 2차원 도형을 정의하는 클래스들이 포함되어 있다.
	- 버튼의 이미지를 제작하거나 배경 이미지를 만들 때 사용하면 편리하다.

	- XML로 도형 정의하기
	```
	<?xml version="1.0" encoding="utf-8"?>
	<shape
		xmlns:android="http://schemas.android.com/apk/res/android"
		android:shape=["rectangle" | "oval" | "line" | "ring"] >
		
		...

	</shape>
	```

- Transition API 애니메이션
	- 버튼과 텍스트에 간단한 애니메이션 효과를 주는 용도로 많이 사용


- 드로워블 애니메이션
	- 영화 필름처럼 여러 개의 이미지가 순서대로 재생되어서 생성되는 전통적인 애니메이션이다.
	- AnimationDrawable 클래스가 프레임 애니메이션의 기초 클래스

- 서피스 뷰
	- 그리기 전용의 화면을 제공하는 뷰
	```
	class MyView extends SurfaceView implements SurfaceHolder.Callback{
		public void surfaceCreated(SurfaceHolder holder){
			// 서피스가 준비되었으므로 스레드를 시작한다.
		}

		public void surfaceDestroyed(SurfaceHolder holder){
			// 서피스가 소멸되었으므로 스레드를 종류한다.
		}

		public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){
			// 서피스가 변경
		}
	}

	class MyThread extends Thread {
		SurfaceHolder holder;
		...
		public void run(){
			canvas = holder.lockCanvas();
			// 캔버스에 그림을 그린다.
			...
			...
			holder.unlockCanvasAndPost(canvas);
		}
	}
	```

---
## **7. 고급 위젯과 프래그먼트**

1. 어댑터 뷰(AdapterView) 클래스
	- 화면에서 동적으로 변경되는 콘텐츠를 채울 때 사용
	- 배열, 파일, 데이터베이스에서 저장된 데이터를 읽어서 화면에 표시할 때 유용한 뷰
		- 리스트 뷰(ListView)
		- 갤러리(Gallery)
		- 그리드 뷰(GridView)

	- 어댑터 뷰에 데이터를 공급하는 클래스가 **어댑터(Adapter)** 이다.
	- 어댑터는 데이터 소스와 어댑터 뷰 중간에 위치하여서 데이터 소스에서 데이터를 읽어서 어댑터 뷰에 공급한다.
		- ArrayAdapter : 배열에서 데이터를 가져옴
		- SimpleCursorAdapter : 데이터베이스에서 데이터를 가져옴
	
		`데이터 -> Adapter -> AdapterView`
	
2. 리스트 뷰(ListView)
	- 리스트 뷰는 항목들을 수직으로 보여주는 어댑터 뷰로 상하로 스크롤이 가능
	- 스마트폰에서 사용하기 쉽기 때문에 아주 많이 사용
	- ListActivity 클래스 사용

	`ArrayAdapter(Context context, int textViewResourceId, T[] object)`

	`현재 애플리케이션 컨텍스트, 레이아웃 아이디, 배열`

	- 두 번째 매개변수인 레이아웃 아이디는 사용자가 직접 지정할 수도 있지만, 통상적으로 안드로이드가 제공하는 표준적인 레이아웃을 사용할 수도 있다.
	
	```
	R.layout 클래스 파일 안에 정의되어있다.
	- simple_list_item_1			:	한 개의 텍스트 뷰 사용
	- simple_list_item_2			:	두 개의 텍스트 뷰 사용
	- simple_list_item_checked		:	항목당 체크 표시
	- simple_list_item_single_choice	:	한 개의 항목만 선택
	- simple_list_item_mutiple_choice	:	여러 개의 항목 선택 가능
	```
	
	- ListActivity 클래스는 ListView를 화면으로 사용하는 액티비티이다.
	- setListAdapter()를 호출하여서 리스트뷰와 어댑터를 연결
	- onListItemClick()은 리스트의 항목이 클릭되면 호출
	
	```
	ArrayAdaptor 클래스는 제네릭 클래스로 정의되어 있다.
	제네릭 클래스란 타입 매개변수를 사용하여서 클래스 안에서 사용되는 데이터 타입을 마음대로 변경할 수 있는 클래스이다.
	제네릭 클래스에서 타입 매개변수는 객체 생성 시에 프로그래머에 의해 결정된다.
	<...> 를 사용하여서 사용하고 싶은 타입을 지정하면 된다.
	
	new ArrayAdapter<String>(...)

	ArrayAdapter 클래스
	T 타입 참조 변수
	T = Integer		->	Integer 객체 '10'
	T = String		->	String 객체 "Hello World!"
	```

3. 그리드 뷰(GridView)
	- 2차원 그리드에 항목들을 표시하는 뷰그룹이다.

4. 스피너(Spinner)
	- 항목을 선택하기 위한 드롭 다운 리스트와 유사하다.
	- 기본적인 상태에서는 현재 선택된 값을 보여준다.

5. 프로그레스 바(ProgressBar)
	- 작업의 진행 정도를 표시하는 위젯이다.

	- 시크 바(SeekBar)
		- 프로그레스 바의 확장판이다. 사용자가 드래그할 수 있는 썸(thumb)이 추가

6. 레이팅 바(RatingBar)
	- 시크 바와 프로그레스 바의 확장판이다.
	- 별을 사용하여 점수를 표시한다.
	- ratingBarStyleSmall : 작은 크기
	- ratingBarStyleIndicator : 표시만 되고 사용자 상호작용 지원XX
	- 사용자 상호작용 지원하는 레이팅 바를 사용할 때는 왼쪽이나 오른쪽에 위젯을 두지 말아야 한다.
	- 별들의 개수는 setNumStars(int) 나 XML레이아웃(너비가 wrap_content)으로 설정


7. 프래그먼트(Fragment)
	- 액티비티의 사용자 인터페이스를 여러 개의 조각으로 나눌 수 있고, 이 조각을 프래그먼트라고 한다.
	- 서브 액티비티(sub-activity)

8. 다중 창 지원
	- Android N에서는 둘 이상의 앱을 동시에 표시할 수 있다.
	- PIP 모드

---
## **8. 액티비티와 인텐트**

1. 애플리케이션, 액티비티, 액티비티 스택, 태스크
	- 안드로이드와 같은 모바일 플랫폼은 일반적인 컴퓨터의 실행 환경과는 약간 차이가 있다.
	- 일반적인 컴퓨터에서는 애플리케이션 단위로 실행되지만, 안드로이드에서는 액티비티 단위로 실행된다.
	
	- 애플리케이션
		- 애플리케이션은 여러 개의 액티비티들로 구성된다.
		- 안드로이드 안에는 많은 애플리케이션들이 내장되어 있다.
	
	- 액티비티
		- 사용자가 어떤 작업(전화를 거는 작업, 사진을 찍는 작업, ...)을 할 수 있는 화면을 가지고 있는 애플리케이션 구성 요소이다.
		- 각 액티비티는 사용자 인터페이스가 그려지는 윈도우를 가지고 있다.
		- 안드로이드에서 실행 단위는 액티비티이다.
		- 하나의 액티비티에서 다른 액티비티를 시작하려면 startActivity()를 호출한다.
		- 다른 애플리케이션의 액티비티도 실행 가능
		- 안드로이드는 두 개의 액티비티를 같은 태스크 안에서 유지한다.
		- 태스크는 어떤 작업을 수행하기 위하여 사용자가 상호작용하는 액티비티들의 그룹이다.
	
	- 태스크와 백 스택
		- 사용자가 BACK 버튼을 터치하면 현재 액티비티가 종료되고 이전 액티비티로 되돌아간다.
		- 따라서 사용자가 방문한 액티비티들은 어딘가에 기억되어 있어야 한다.
		- 이런 용도로 사용되는 것이 백 스택 또는 액티비티 스택이라고도 한다.
		- 장치의 홈 화면은 대부분의 태스크가 시작되는 곳이다.
		- 사용자가 아이콘을 터치하면 애플리케이션의 태스크를 찾는다.
		- 만약 최근에 실행되지 않아서 애플리케이션을 위한 태스크가 없다면 새로운 태스크가 생성되고 애플리케이션의 메인 액티비티가 스택의 바닥에 추가된다(이것을 루트 액티비티라고 한다).

			| 액티비티3 | ← 현재 실행되는 액티비티
			| 액티비티2 |
			| 액티비티1 |
			------------
			액티비티 스택

		- 현재 액티비티가 다른 액티비티를 시작하면 이 액티비티가 스택의 맨 위에 삽입된다(push).
		- 스택의 맨 위에 있는 액티비티는 현재 실행되고 있는 액티비티이다.
		- 사용자가 BACK 키를 누르면 현재 액티비티는 스택에서 제거된다(pop).
		- 스택에 있는 액티비티들은 절대로 위치가 변경되지 않기 때문에 스택에 동일한 액티비티가 이미 존재하더라도 다시 스택의 윗부분에 추가될 수 있다.

			| 액티비티3 |
			| 액티비티1 |
			| 액티비티2 |
			| 액티비티1 |
			------------

2. 인텐트
	- 하나의 액티비티에서 다른 액티비티를 시작하려면 액티비티의 실행에 필요한 여러 가지 정보들을 보내주어야 한다. 이때 사용하는 메시지가 인텐트이다.
	- 액티비티와 같은 컴포넌트들은 인텐트라고 불리는 메시지를 통해서 활성화된다.
	
	- 명시적 인텐트(explicit intent)
		- 명시적 인텐트에서 타깃 컴포넌트의 이름을 지정한다.
		- 즉, "애플리케이션 A의 컴포넌트 B를 구동시켜라"와 같이 명확하게 지정하는 것이다.
		- 동일한 애플리케이션 내에 있는 다른 액티비티를 실행하는 데 사용된다.

	- 암시적 인텐트(implicit intent)
		- 암시적 인텐트에서는 타깃 컴포넌트의 이름을 지정하지 않는다.
		- 예를 들면, "지도를 보여줄 수 있는 컴포넌트이면 어떤 것이라도 좋다"와 같다.
		- 다른 애플리케이션의 컴포넌트를 구동하는데 사용된다.
	
3. 명시적 인텐트
	```
	현재의 액티비티에서 다른 액티비티로 넘어갈 수 있다.
	Intent intent = new Intent(this, NextActivity.class);
	startActivity(intent);
	```
4. 여러 페이지로 구성된 애플리케이션 작성
	```

	```
5. 액티비티로부터 결과받기
	- 서브 액티비티로부터 결과를 받아야 하는 경우 startActivity()가 아닌 startActivityForResult()를 호출하여서 서브 액티비티를 시작하여야 한다.
	- 서브 액티비티가 결과를 보내면 메인 액티비티의 onActivityResult() 콜백 메소드가 호출됨.
	```
	...
	public class MainActivity extends AppCompatActivity {
		...
		// 서브 액티비티를 시작한다.
		Intent in = new Intent(MainActivity.this, SubActivity.class);
		startActivityForResult(in, COMMAND);

		@Override
		protected void onActivityResult(int requestCode, int resultCode, Intent data){
			...	/// 여기서 값을 전달받는다.
		}
	}
	```
6. 암시적 인텐트
	- 만약 어떤 작업을 하기를 원하지만 그 작업을 담당하는 컴포넌트의 이름을 명확하게 모르는 경우에 사용
	- 암시적 인텐트에는 자신이 원하는 작업만을 기술한다.
	- 매니페스트 파일의 인텐트 필터와 암시적 인텐틀르 비교하여서 가장 일치하는 컴포넌트를 찾는다.
	```
	Intent intent = new Intent(Intent.ACTION_SEND);		 // 이메일 전송을 의미하는 인텐트 생성
	intent.putExtra(Intent.EXTRA_EMAIL, recipientArray); // 이메일의 송신자를 엑스트라 필드에 기술한다.
	startActivity(intent);
	```

	- 인텐트 객체
		- 상당한 정보의 묶음이다.
		- 컴포넌트 이름 - 인텐트를 처리하는 타깃 컴포넌트의 이름이다.
			타깃 컴포넌트의 완전한 이름과 패키지 이름을 적어주면 된다.
			만약 컴포넌트의 이름이 없으면 암시적 인텐트가 되어서 안드로이드가 최적의 타깃 컴포넌트를 찾아준다.
			setComponent(), setClass(), setClassName()으로 설정, getComponent()로 읽을 수 있다.

		- 액션 - 수행되어야 하는 작업

		```
		ACTION_VIEW	- 데이터를 사용자에게 표시
		ACTION_EDIT - 사용자가 편집할 수 있는 데이터를 표시
		ACTION_MAIN - 태스크의 초기 액티비티로 설정
		ACTION_CALL - 전화 통화 시작
		ACTION_SYNC - 모바일 장치의 데이터를 서버 상의 데이터와 일치시킨다.
		ACTION_DIAL - 전화번호를 누르는 화면 표시
		```
		
		- 데이터 - 작업에 필요한 데이터
			ACTION_VIEW이면 무엇을 사용자에게 표시할 것인지를 주어야 한다.
			데이터는 URI 형식을 사용한다.
			setData()와 getData()를 사용하여서 인텐트 객체에 데이터를 설정하고 접근할 수 있다.

			```
			ex)
			ACTION_VIEW		content://contacts/people/1	- 1번 연락처 정보를 표시
			ACTION_DIAL		content://contacts/people/1 - 1번 연락처로 전화걸기 화면을 표시
			ACTION_DIAL		tel:0101234567 - 0101234567번 전화번호로 전화걸기 화면을 표시
			ACTION_EDIT		content://contacts/people/1	- 1번 연락처 정보를 편집
			ACTION_VIEW		content://contacts/people/	- 연락처 리스트를 표시
			```

			```
			...
			Intent intent = new Intent(Intent.ACTION_CALL);	// 액션이 ACTION_CALL인 인텐트 생성
			intent.setData(Uri.parse("tel:01012341234"));	// 01012341234번 전화번호를 데이터로 설정
			startActivity(intent);	// 인텐트 시작
			...
			```

		- 카테고리 - 액션에 대하여 추가적인 정보를 제공
		
		- 엑스트라 - 타깃 컴포넌트로 전달되어야 하는 추가적인 정보를 가지고 있다.
			put...() 메소드를 이용하여서 엑스트라 데이터 추가
			get...() 메소드를 이용하여서 엑스트라 데이터 읽음

7. 멀티태스킹
	```
	배경           전경
	|          |  | 액티비티Z |
	| 액티비티2 |  | 액티비티Y |
	| 액티비티1 |  | 액티비티X |
	------------   -----------
	   태스크 A       태스크 B
	```

	- 안드로이드에서는 동시에 여러 태스크를 실행할 수 있으며 태스크 간에 스위칭이 가능하다.
	- 태스크 안의 모든 액티비티는 하나의 단위로 이동한다.
	- 안드로이드에서 멀티태스킹을 시작하는 가장 일반적인 방법은 HOME키를 누르는 것이다.
	- HOME 키를 누르면 현재의 태스크는 중단되지만 종료되지는 않은 상태에서 배경으로 이동한다.

	```
	사용자동작 / 전경태스크 / 배경태스크
	=================================
	HOME 버튼 /  배경화면
	▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
	계산기시작 /  계산기    / 배경화면			
	▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
	HOME 버튼 /  배경화면   / 계산기
	▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
	캘린더시작 /  캘린더    / 배경화면
	                       / 계산기	
	```

	- HOME 버튼을 누르면 태스크 A가 배경으로 간다.
	```
	전경태스크          배경태스크
	| 액티비티A3 |
	| 액티비티A2 |
	| 액티비티A1 |
	-------------
	   태스크A
	```

	- 태스크 B를 선택하여 실행한다.
	```
	전경태스크           배경태스크
	                   | 액티비티A3 |
	| 액티비티B2 |      | 액티비티A2 |
	| 액티비티B1 |      | 액티비티A1 |
	-------------	    ------------
	   태스크B              태스크A
	```

	- HOME 버튼을 누르고 태스크 A를 다시 선택하면 태스크 A가 전경으로 온다.
	```
	전경태스크           배경태스크
	| 액티비티A3 |
	| 액티비티A2 |      | 액티비티B2 |
	| 액티비티A1 |      | 액티비티B1 |
	-------------	    ------------
	   태스크A             태스크B
	```

	- 오버뷰 화면(overview screen) - 최근에 사용된 액티비티들과 태스크들을 보여준다.

8. 태스크 관리하기
	- 안드로이드가 태스크를 관리하는 기본적인 방법은 실행되는 액티비티들을 차례대로 스택에 넣고 **후입선출(Last-In First-Out)** 원칙을 적용하는 것이다.
	- 매니페스트 파일의 activity 요소 속성을 변경하는 것, startActivity()에 전달하는 인텐트의 플래그를 우리가 원하는 값으로 설정하는 것, 두가지 방법을 사용할 수 있다.

	- 액티비티 구동 모드
		- activity 요소의 launchMode 속성을 이용
		
		- standrad(디폴트 모드)
			- 시스템은 액티비티가 시작된 태스크에 액티비티 인스턴스를 생성하고 인텐트를 전달한다.
			  액티비티는 여러 번 인스턴스화될 수 있으며 각 인스턴스는 서로 다른 태스크에 속할 수 있다.
			  하나의 태스크는 여러 개의 인스턴스를 가질 수 있다.

		- singleTop
			- 액티비티의 인스턴스가 스택의 맨 위에 있다면 새로운 인스턴스를 생성하지 않고 인텐트를 기존의 인스턴스에 전달한다.
			- 이 때, onNewIntent() 메소드가 호출된다.
			- 하나의 태스크는 여러 개의 인스턴스를 가질 수 있지만, 스택의 맨 위에는 동일한 액티비티의 인스턴스가 있는 경우에는 예외이다.

			```
			* Standard

			|          |                      |          |                      | 액티비티B |
			|          |                      | 액티비티B |                      | 액티비티B |
			| 액티비티A | -> 액티비티 B 시작 -> | 액티비티A | -> 액티비티 B 시작 -> | 액티비티A |
			
			* SingleTop

			|          |                      |          |                      |          |
			|          |                      | 액티비티B |                      | 액티비티B |
			| 액티비티A | -> 액티비티 B 시작 -> | 액티비티A | -> 액티비티 B 시작 -> | 액티비티A |
			```
		
		- singleTask
			- 액티비티가 생성될 때, 새로운 태스크가 생성되고 액티비티는 새로운 태스크의 루트가 된다.
			- 그러나 액티비티가 이미 별도의 태스크로 수행되고 있다면, 새로운 액티비티는 생성되지 않고 기존의 액티비티로 onNewIntent()를 통하여 인텐트가 전달된다.
			- 액티비티는 하나만 존재할 수 있다.

			```
			* SingleTask

			|          |                      |          |  |          |
			| 액티비티B |                      | 액티비티B |  |          |
			| 액티비티A | -> 액티비티 C 시작 -> | 액티비티A |  | 액티비티C |
			```
		- singleInstance
			- "singleTask" 와 동일하지만 태스크에 다른 액티비티들을 구동하지 않는다.
			- 액티비티는 하나만 존재할 수 있으며 이것이 태스크의 유일한 멤버가 된다.
			- 이 액티비티가 시작하는 다른 액티비티들은 모두 별도의 태스크에서 시작된다.

	- 인텐트 플래그 사용하기
		- startActivity()를 사용하여 액티비티를 시작할 때, 인텐트의 플래그를 사용하여서 액티비티와 태스크의 관계를 변경할 수 있다.

		- FLAG_ACTIVITY_NEW_TASK
			- 액티비티를 새로운 태스크 안에서 시작한다.
			- 만약 우리가 시작하려고 하는 액티비티를 다른 태스크가 이미 실행하고 있다면 그 태스크가 전경으로 이동한다.
			- onNewIntent()가 새로운 인텐트를 받는다.
			- "singleTask" 구동모드와 동일하게 동작

		- FLAG_ACTIVITY_SINGLE_TOP
			- 시작된 액티비티가 이미 스택의 맨 위에 있다면, 새로운 액티비티가 생성되지 않고, 기존의 액티비티가 onNewIntent()를 통하여 인텐트를 전달받는다.
			- "singleTop" 구동모드와 동일하게 동작

		- FLAG_ACTIVITY_CLEAR_TOP
			- 시작된 액티비티가 이미 현재 태스크에서 실행되고 있으며, 새로운 액티비티가 만들어지는 것이 아니라 기존의 액티비티가 다시 실행되며, 스택에서 기존의 액티비티 위에 있던 액티비티들은 모두 파괴된다.
			- onNewIntent()를 통하여 인텐트를 전달받는다.
			- FLAG_ACTIVITY_CLEAR_TOP은 흔히 FLAG_ACTIVITY_NEW_TASK와 같이 사용된다.

			```
			| 액티비티D |                      |          |
			| 액티비티C |  -> 액티비티B 시작 -> |          |
			| 액티비티B |                      | 액티비티B |
			| 액티비티A |                      | 액티비티A |
			```

9. 인텐트 필터
	- 컴포넌트가 처리할 수 있는 인텐트를 적어놓은 것이다.
	- 암시적 인텐트에 국한된다.
	- 명시적 인텐트는 무엇을 포함하고 있는지 상관없이 항상 타깃 컴포넌트로 전달된다.
	- 암시적 인텐트는 필터를 통과해야만 컴포넌트로 전달된다.

	- 인텐트와 인텐트 필터 비교
		1. 액션 비교
			```
			<intent-filter ...>
				<action android:name="com.example.project.SHOW_CURRENT" />
				<action android:name="com.example.project.SHOW_RECENT" />
				<action android:name="com.example.project.SHOW_PENDING" />
				...
			</intent-filter>
			```

			- 인텐트의 액션은 필터에 나열된 액선 중의 하나와 반드시 일치하여야 한다.
			- 만약 필터가 어떤 액션도 나열하지 않았다면 어떤 인텐트도 필터를 통과할 수 없다.
			- 만약 인텐트 객체가 어떤 액션도 지정하지 않았다면 자동적으로 필터를 통과한다.

		2. 카테고리 비교
			```
			<intent-filter ...>
				<category android:name="android.intent.category.DEFAULT" />
				<category android:name="android.intent.category.BROWSABLE" />
				...
			</intent-filter>
			```

			- 인텐트 객체 안의 모든 카테고리가 필터의 카테고리와 일치되어야 한다.
			- 카테고리를 가지지 않은 인텐트 객체는 항상 카테고리 테스트를 통과한다.

		3. 데이터 비교
			```
			<intent-filter>
				<data
					android:mimeType="video/*"
					android:scheme="http" />
				...
			</intent-filter>
			```

			- 데이터 타입이나 URI를 지정하지 않은 인텐트는 필터가 아무런 URI나 데이터 타입을 지정하지 않은 경우에만 테스트를 통과한다.
			- 데이터 타입이나 URI 중에서 하나만 지정한 인텐트는 필터도 똑같이 하나만 지정한 경우에 테스트를 통과한다.
			- 데이터 타입과 URI를 모두 지정한 인텐트는 데이터 타입과 URI가 모두 필터와 일치하여야 한다.

			- 노트패드 예제
			```
			AndroidManifest.xml
			<manifest xmlns:android="http://schemas.android.com/apk/res/android"
						package="com.example.android.notepad" >
				<application android:icon="@drawable/app_notes"
								android:label="@string/app_name" >
				...
					<activity android:name="NotesList" android:label="@string/title_notes_list" >
						<!-- 이 필터는 이 액티비티가 노트 패드 애플리케이션의 진입임을 표시한다. 즉, 액션이 MAIN이면 진입점을 표시하고 LAUNCHER 카테고리는 이 액티비티가 애플리케이션 런처에 나열되어야 함을 의미한다. -->
						<intent-filter>
							<action android:name="android.intent.action.MAIN" />
							<category android:name="android.intent.category.LAUNCHER" />
						</intent-filter>
						<!-- 이 필터는 액티비티가 노트들의 디렉터리에 대하여 할 수 있는 것들을 선언한다. 사용자로 하여금 디렉터리를 보거나(VIEW) 편집(EDIT)할 수 있도록 허용하고 또 디렉터리에서 특정한 노트를 선택(PICK)할 수 있도록 한다.
						<data>에서 mimeType은 이들 액션이 적용되는 데이터의 종류를 지정한다. 만약 이런 종류의 데이터 타입을 지정하는 인텐트 객체가 전달되면 이 액티비티가 구동될 것이다.
						DEFAULT 카테고리가 포함된 이유는 startActivity() 메소드가 모든 인텐트가 DEFAULT 카테고리를 포함하고 있다고 가정하기 때문이다. 따라서 DEFAULT 카테고리는 모든 필터에서 반드시 필요하다. -->
						<intent-filter>
							<action android:name="android.intent.action.VIEW" />
							<action android:name="android.intent.action.EDIT" />
							<action android:name="android.intent.action.PICK" />
							<category android:name="android.intent.category.DEFAULT" />
							<data android:mimeType="vnd.android.cursor.dir/vnd.google.note" />
						</intent-filter>
						<!-- 이 필터는 사용자가 선택한 노트를 반환하기 위하여 필요하다. GET_CONTENT 액션은 PICK 액션과 유사하다. 이들은 모두 사용자가 선택한 노트의 Uri를 반환한다. 실제로 이들은 startActivityForResult()를 호출한 액티비티로 반환된다. -->
						<intent-filter>
							<action android:name="android.intent.action.GET_CONTENT" />
							<category android:name="android.intent.category.DEFAULT" />
							<data android:mimeType="vnd.android.cursor.item/vnd.google.note" />
						</intent-filter>
					</activity>

					<activity android:name="NoteEditor">
								android:theme="@android:style/Theme.Light"
								android:label="@string/title_note" >
					...
					</activity>

					<activity android:name="TitleEditor" 
								android:label="@string/title_edit_title"
								android:theme="@android:style/Theme.Dialog" >
						...
					</activity>
				</application>
			</manifest>
			```

10. 액티비티 생애주기
	- 실행 상태 : 액티비티가 전경에 위치하고 있으며 사용자의 포커스를 가지고 있다.
	- 일시멈춤 상태 : 다른 액티비티가 전경에 있으며 포커스를 가지고 있지만 현재 액티비티의 일부가 아직도 화면에서 보이고 있는 상태이다.
	일시멈춤 상태에 있는 액티비티도 살아있다고 할 수 있다.
	즉 모든 상태를 유지하고 있으며 정보를 기억하고 있고 윈도우 관리자에 연결되어 있다.
	그러나 시스템이 낮은 메모리 상태가 되면 제거될 수도 있다.
	- 정지 상태 : 액티비티가 화면에서 전혀 보이지 않는 상태이다.
	액티비티는 배경에 위치한다.
	아직까지는 상태와 멤버 정보를 가지고 있다.
	하지만 시스템이 메모리가 필요하면 언제든지 종료시킬 수 있다.
	
	![image](lifecycle.png)

	- 액티비티 객체 생성 단계
		안드로이드 시스템은 액티비티의 onCreate()를 호출하여서 액티비티 객체를 생성한다.
		따라서 onCreate()에는 딱 한번 실행되는 초기화 코드가 포함되어야 한다.
		전형적으로 사용자 인터페이스 정의와 클래스 수준의 변수들이 생성되고 초기화된다.
		onCreate()가 실행을 완료하면 바로 이어서 onStart()와 onResume()이 호출된다.
		onResume()이 호출된 후에는 애플리케이션은 실행 상태에 머무르며, 전화가 오거나 사용자가 다른 액티비티로 이동하기 전까지 그 상태를 유지한다.

	- 일시멈춤 상태
		만약 전경 액티비티가 대화 상자에 의하여 가려지면 액티비티는 일시멈춤 상태에 들어간다.
		액티비티가 일시멈춤 상태에 진입하면 onPause()가 호출된다.
		따라서 onPause()를 재정의하여서 일시 멈춤 상태에 해당되는 동작을 수행할 수 있다.
		예를 들어서 비디오 재생 애플리케이션이라면 비디오를 중지시키는 동작을 수행할 수 있다.
		또 사용자가 액티비티를 떠날 것을 대비하여서 어떤 정보를 저장하는 것도 onPause()에서 해야하는 작업이다.
		만약 사용자가 일시멈춤 상태에서 실행 상태로 되돌아오면 onResume()이 호출된다.

	- 정지되었다가 다시 실행하는 경우
		만약 사용자가 현재의 액티비티에서 새로운 액티비티를 실행하게 되면 현재의 액티비티는 정지된 상태가 된다.
		이때 onStop()이 호출된다.
		반대로 정지되었던 액티비티가 다시 실행되면 onRestart()가 호출된다.
		정지된 상태에서는 사용자 인터페이스는 더 이상 사용자에게 보여지지 않으며 사용자의 포커스는 다른 액티비티에 있다.
		따라서 onStop()에서는 현재 사용중인 대부분의 리소스를 반납하여야 한다.
		리소스를 반납하지 않으면 메모리 누수가 발생할 수도 있다.
		왜냐하면 안드로이드 시스템이 메모리가 부족해지면 사전 경고없이 액티비티를 제거할 수 있기 때문이다.
		반대로 onRestart()에서는 onStop()에서 반납하였던 리소스들을 다시 생성하여야 한다.
		onStop()과 onRestart()는 서로 반대되는 동작을 수행하는 것이 좋다.
		
	- 콜백 메소드
		콜백 메소드 중에서 가장 중요한 2가지
		- onCreate() : 반드시 구현해야 하는 메소드로서 액티비티가 생성되면서 호출된다.
		이 메소드에서 액티비티의 중요한 구성요소들을 초기화하여야 한다.
		가장 중요한 작업은 액티비티의 화면을 setContentView()를 호출하여서 화면을 설정하는 것이다.
		- onPause() : 사용자가 액티비티를 떠나고 있을 때, 이 메소드가 호출된다.
		액티비티가 완전히 소멸되는 것은 아니지만 사용자가 돌아오지 않을 수도 있기 때문에, 여기서는 그동안 이루어졌던 변경사항을 저장하여야 한다.

		`액티비티 생애 주기 관련 콜백 메소드에서는 반드시 슈퍼클래스의 메소드를 호출하여야 한다.`
		
		하나의 액티비티가 다른 액티비티를 시작하는 경우에 콜백 메소드가 호출되는 순서는 다음과 같다.
		1. 액티비티 A의 onPause() 메소드가 호출된다.
		2. 액티비티 B의 onCreate(), onStart(), onResume()이 순서대로 호출된다.
		3. 만약 액티비티 A가 더 이상 화면에서 보이지 않으면 액티비티 A의 onStop() 메소드가 호출된다.

		첫 번째 액티비티에서 데이터베이스에 데이터를 기록하고 두 번째 액티비티가 이것을 읽는다면 반드시 첫 번째 액티비티의 onPause()에서 데이터를 기록해야 한다.
		onStop()에서 기록하면 두 번째 액티비티가 데이터를 읽을 수 없다.

11. 액티비티 상태 저장
	액티비티가 일시적으로 멈추거나 정지될 때에도 액티비티의 상태는 보존된다.
	왜냐하면 액티비티 객체는 아직 메모리에 존재하고 있기 때문이다.
	따라서 이들 액티비티 안에서 사용자가 변경한 내용들은 메모리에 보존되어 있다.
	하지만 시스템이 메모리를 확보하기 위하여 강제로 액티비티를 종료하는 경우에는 액티비티 객체가 파괴되므로 사용자가 변경한 부분은 없어진다.
	이런 경우에도 사용자는 아마 이전 상태가 그대로 보존되어 있다고 생각하고 되돌아올 수 있다.
	따라서 이런 경우를 대비하여서 액티비티의 현재 상태를 저장하는 것이 필요하다.

	액티비티가 제거되기 전의 상태를 저장하려면 onSaveInstanceState() 메소드를 구현하면 된다.
	시스템은 onPause()를 호출하기 전에 onSaveInstanceState()를 호출한다.
	매개변수인 Bundle 객체에 "이름-값(name-value)"의 형식으로 액티비티의 동적인 상태를 기록할 수 있다.
	액티비티가 다시 시작되면 Bundle 객체는 onCreate()와 onRestoreInstanceState()에 전달된다.
	onRestoreInstanceState()는 onStart()에 이어서 호출되는 메소드이다.
	여기서 저장된 메소드를 다시 복원할 수 있다.
	
	그러나 만약 개발자가 onSaveInstanceState()를 전혀 구현하지 않는다고 하더라고 액티비티의 일부 정보는 Activity 클래스의 onSaveInstanceState()에 의하여 저장된다.
	특히 Activity 클래스의 onSaveInstanceState()는 각 뷰에 대하여 onSaveInstanceState()를 호출하게 되는데 이때 각 뷰들은 자신의 정보를 저장한다.
	안드로이드의 모든 위젯들은 이 메소드를 충실하게 구현하고 있다.
	즉 사용자 인터페이스에 가해진 변경은 자동적으로 저장되고 복구된다.
	예를 들어서 EditText 위젯은 사용자가 입력한 텍스트를 저장하고 CheckBox 위젯은 사용자가 체크한 상태를 저장한다.
	개발자는 각 위젯에 대하여 유일한 ID(android:id 어트리뷰트)만 제공하면 된다.
	만약 위젯이 ID를 가지고 있지 않으면 상태를 저장할 수 없다.
	onSaveInstanceState()의 디폴트 구현이 사용자 인터페이스의 상태를 저장하는 데 큰 도움을 주기 때문에 이 메소드를 재정의할 떄는 반드시 부모클래스의 onSaveInstanceState()을 먼저 호출하여야 한다.

	- Bundle 클래스
	Bundle 클래스는 일종의 Map 자료구조를 구현한 클래스이다.
	키와 값을 받아서 객체 안에 저장한다.
	키는 문자열로 되어 있다.
	안드로이드에서는 액티비티 간에 데이터를 주고받을 때, 바로 Bundle 객체가 사용된다.
	또 액티비티의 상태를 저장하였다가 복원하는 데도 Bundle 객체가 사용된다.
	안드로이드 레퍼런스 문서를 보면 getBoolean(String key), getInt(String key), getDouble(String key), ... 등의 접근자 메소드와, putBoolean(String key, boolean value), putInt(String key, int value), putDouble(String key, double value)등의 설정자 메소드를 제공한다.

		putInt(String key, int value) -> bundle 객체 -> getInt(String key)
	
	자세한 설명은 http://developer.android.com/reference/android/os/Bundle.html을 참고

	```
	- 장치 구성(configuration) 변경을 처리하는 방법
	장치 구성은 실행 도중에도 변경될 수 있다.
	예를 들면 화면의 방향이나 키보드 구성, 언어를 사용자가 액티비티 실행 도중에 변경할 수 있다.
	이러한 변경이 일어나면 안드로이드는 실행 중인 액티비티들을 일단 강제 종료하였다가 다시 시작한다.
	즉, onDestroy()가 호출되고 이어서 onCreate()가 호출된다.
	다시 시작할 때는 자동적으로 적절한 리소스를 가지고 애플리케이션을 다시 적재하게 된다.
	개발자는 이러한 구성 변경을 적절하게 처리하여야 한다.
	가장 좋은 방법은 애플리케이션 상태를 onSaveInstanceState()를 이용하여서 저장하였다가 onRestoreInstanceState()에서 복원하는 것이다.
	```

---
## **9. 리소스와 보안**

1. 리소스
	- 리소스란 이미지, 문자열, 레이아웃, 동영상 파일 등을 의미한다.
	리소스는 특별하게 이름 지어진 리소스 디렉터리에 모여 있어야 한다.
	애플리케이션이 실행될 때에 현재 장치에 가장 적절한 리소스를 자동으로 찾아서 사용하게 된다.
	예를 들어서 화면 크기에 가작 적절한 이미지를 읽어 들어거나 현재 설정된 언어에 가장 적절한 문자열을 사용하게 된다.
	모든 리소스들은 프로젝트의 res 디렉터리에 저장된다.

	```
	- res
		- drawable	: 이미지 리소스
		- layout	: 사용자 인터페이스 레이아웃을 정의하는 XML파일
		- mipmap	: 각기 다른 런처 아이콘 밀도에 대한 드로어블 파일
		- values	: 문자열, 점수 및 색과 같은 단순 값이 들어있는 XML파일
	```

	```
	리소스를 외부에 저장하는 이유
	- 리소스가 코드와 분리되어 있어야 장치의 특성에 따라 리소스들을 쉽게 교체할 수 있기 때문
	```

2. 기본 리소스와 대체 리소스
	- 기본 리소스
	장치 구성과 상관없이 기본적으로 사용되는 리소스이다.

	- 대체 리소스
	특정한 장치 구성을 위하여 설계된 리소스이다.
	안드로이드는 자동으로 장치의 현재 구성과 리소스 디렉터리 이름을 매치하여서 적절한 리소스를 적용한다.

	- 대체 리소스의 제공 절차
		1. 먼저 res\ 디렉터리 안에 <resources_name>-<config_qualifier>의 형식의 새로운 디렉터리를 생성한다.
			- <resources_name>은 기본 리소스의 디렉터리 이름이다.
			- <qualifier>는 특정한 구성을 나타내는 수식자이다.

		2. 이 새로운 디렉터리 안에 대체 리소스를 저장한다.
		리소스 파일의 이름은 기본 리소스와 같아야 한다.

		```
		ex)
		res\
			drawable\
				icon.png
				background.png
			drawable-hdpi\
				icon.png
				background.png
		```

		이런 식으로 안드로이드는 현재 장치에 가장 알맞은 리소스를 선택한다.
		즉 현재 장치가 고해상도 화면을 가지고 있다면 자동적으로 res/drawable-hdpi 디렉터리에서 이미지를 읽어온다.
		
3. 리소스 참조
	우리는 리소스 아이디를 통하여 리소스를 참조할 수 있다.
	모든 리소스 아이디는 R.java 파일에서 정의된다.
	R.java파일에는 R클래스가 들어 있으며, aapt도구가 자동적으로 R클래스를 생성한다.
	R클래스 안에는 res 디렉터리에 저장된 리소스에 대한 리소스 아이디가 정의되어 있다.
	자세히 살펴보면 각각의 리소스 타입에 대하여 별도의 내부클래스가 정의되어 있는 것을 알 수 있다.
	예를 들어서, 모든 drawable 리소스에 대해서는 R.drawable클래스가 정의된다.
	내부 클래스 안에는 정적 상수들이 정의되어 있고 중복되지 않는 값으로 초기화되어 있다.
	예를 들어서 R.drawable.icon이라는 정적 상수가 정의되어 있다.
	이 정적 상수가 바로 리소스를 참조할 때 사용하는 리소스 아이디이다.
	리소스 아이디는 리소스 타입과 리소스 이름을 합쳐서 만든다.
	리소스 타입은 string, layout, drawable과 같이 리소스의 종류를 나타낸다.
	리소스 이름은 일반적으로 확장자를 제외한 파일 이름이다.
	
	- 코드에서 리소스 참조
	코드에서 리소스를 참조하려면 R 클래스 안에 정의된 정적 상수를 사용한다.
	예를 들어서 다음과 같다.

	`R.string.hello`

	여기서 string은 리소스 타입이고 hello는 리소스 이름이다.
	예를 들어서 /res/drawable 폴더에 있는 image.png를 이미지 뷰에 나타내려면 다음과 같은 문장을 사용한다.
	
	```
	imageView.setImageResource(R.drawable.image);
	setContentView(R.layout.activity_main);
	```

	- XML에서 리소스를 참조하는 방법
	XML에서는 리소스를 참조하려면 다음과 같은 문법을 사용한다.
	
	`@string/hello`

	여기서도 string은 리소스 타입, hello는 리소스 이름을 나타낸다.
	예를 들어서 버튼의 텍스트를 문자열 리소스로 설정하면 다음과 같다.

	```
	<Button
		android:layout_width="match_parent"
		android:layout_height="wrap_content"
		android:text="@string/submit" /> ☜ 문자열 타입의 리소스 submit 
	```

	버튼의 텍스트를 정의할 때 실제 문자열을 사용하는 것보다 문자열 리소스를 사용하는 것이 바람직하다.
	이번에는 별도의 XML파일에서 색상 리소스와 문자열 리소스를 다음과 같이 정의하였다고 가정하자.

	```
	<?xml  version="1.0" encoding="utf-8"?>
	<resources>
		<color name="opaque_red">#f00</color> ☜ 이름이 opaque_red인 색상 리소스
		<string name="hello">Hello!</string> ☜ 이름이 hello인 문자열 리소스
	</resources>
	```

	이들 리소스들은 다음과 같은 레이아웃 파일에서 텍스트 컬러와 텍스트 문자열을 설정하기 위하여 사용될 수 있다.

	```
	<?xml  version="1.0" encoding="utf-8"?>
	<EditText xmlns:android="http://schemas.android.com/apk/res/android"
		android:layout_width="match_parent"
		android:layout_height="match_parent"
		android:text="@string/hello"
		android:textColor="@color/opaque_red" />
	```

	```
	만약 리소스가 정의된 패키지가 다르면 다음과 같이 리소스 아이디 앞에 패키지를 적어준다.
	- 코드에서는 다음과 같은 형식을 사용한다.
	[<package_name>.]R.<resource_type>.<resource_name>
	- XML에서는 다음과 같은 형식을 사용한다.
	@<package_name>:]<resource_type>/<resource_name>
	```

	- 스타일 속성을 참조하는 방법
	스타일 속성 리소스는 현재 설정된 테마의 리소스를 사용하는 것이다.
	스타일 속성을 사용하면 사용자 인터페이스 요소들의 외관을 일관성 있게 변경할 수 있다.
	스타일 속성을 사용하는 것은 **"현재 테마에서 이 속성에 의하여 정의된 스타일을 사용하라"**고 말하는 것과 같다.
	스타일 속성을 참조하려면 다음과 같은 형식을 사용한다.

	`?[<package_name>:][<resource_type>/]<resource_name>`

	스타일 속성 리소스는 @대신에 ?를 붙이면 된다.
	예를 들어서 텍스트 색상을 시스템 테마의 기본 색상으로 변경하려면 다음과 같이 적어준다.

	```
	<EditText id="text"
		android:layout_width="match_parent"
		android:layout_height="wrap_content"
		android:textColor="?android:textColorSecondary" ☜ 스타일 속성
		android:text="@string/hello_world" />
	```

	여기서는 android:textColor 값으로 안드로이드 시스템 테마의 android:textColorSecondary 속성이 제공하는 값을 사용한다.

	- 플랫폼 제공 리소스 사용
	안드로이드는 스타일이나 테마, 레이아웃 같은 몇 개의 표준 리소스들을 가지고 있다.
	이들 리소스를 사용하려면 리소스 참조자 앞에 패키지 이름 android를 붙여서 지정하면 된다.
	예를 들어서, 안드로이드는 ListAdapter의 항목을 위해서 표준 레이아웃 리소스를 제공한다.

	```
	setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myarray));
	```

	이 예제에서는 simple_list_item_1이 레이아웃 리소스로 플랫폼에 의하여 정의된다.
	리스트 항목에 대하여 스스로 레이아웃을 작성하여도 되지만 간단히 이 표준 리소스를 사용하여도 된다.

4. 다양한 화면 지원하기
	안드로이드에서는 화면의 크기와 해상도를 이용하여서 장치 화면을 구분한다.
	개발자들은 자신의 앱이 다양한 크기와 해상도를 가지는 장치에 아무런 문제없이 설치되기를 바랄 것이다.
	그러려면 다양한 크기와 해상도를 가지는 화면을 위하여 적절한 자원을 포함시켜야 한다.

	- 화면의 크기에 따른 분류 : small, normal, large, xlarge
	- 화면의 해상도에 따른 분류 : low(ldpi), medium(mdpi), high(hdpi), extra high(xhdpi)

	화면에 적절한 레이아웃과 비트맵을 선언하려면 독립적인 디렉터리에 대체 리소스를 저장하여야 한다.
	또, 화면 방향(수평이나 수직)도 화면 크기의 일종으로 취급된다.
	따라서 많은 앱이 수평 방향의 레이아웃을 다르게 제공하고 있다.

	- 다양한 레이아웃 생성
	다양한 화면 크기에서의 사용자 경험을 최적화하려면, 각 화면 크기마다 별도의 레이아웃 파일을 생성하여야 한다.
	각 레이아웃 파일은 적절한 디렉터리에 저장된다.
	-<screen_size> 접미사가 디렉터리 이름에 붙는다.
	예를 들어서 "xlarge" 화면을 위한 레이아웃은 res/layout-large/ 디렉터리 아래에 저장되어야 한다.
	예를 들어서 기본 레이아웃과 "xlarge" 카테고리 화면을 위한 레이아웃은 다음과 같이 구성될 수 있다.

	```
	MyProject/
		res/
			layout/
				activity_main.xml
			layout-xlarge/
				activity_main.xml
	```

	파일 이름은 동일하지만 레이아웃 파일의 내용은 다르다.
	코드에서는 단순히 레이아웃 파일을 다음과 같이 참조하면 된다.

	```
	@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
		}
	```

	시스템은 개발자의 앱이 실행되는 장치 화면 크기에 따라서 가장 적절한 레이아웃 디렉터리를 선택한다.

	```
	MyProject/
		res/
			layout/				# default (portrait)
				activity_main.xml
			layout-land/		# landscape
				activity_main.xml
			layout-large/		# large (potrait)
				activity_main.xml
			layout-large-land/	# large landscape
				activity_main.xml
	```

	화면 방향이 수직 방향이면 layout/activity_main.xml 이 선택된다.

	```
	참고 : 안드로이드는 자동적으로 화면의 크기에 맞추기 위하여 레이아웃을 확대하거나 축소한다.
	따라서 레이아웃을 작성할 때 UI 요소의 절대적인 크기는 중요치 않다.
	레이아웃의 구조가 중요하다.
	예를 들어서 뷰들의 상대적인 크기에 신경 써야 한다.
	```

	- 비트맵의 생성
	개발자들은 비트맵들도 해상도에 맞추어서 준비할 필요가 있다.
	이들 이미지들은 생성하려면 벡타 형식의 원 이미지로부터 다음과 같은 크기로 이미지들을 생성하는 것이 좋다.

	   - xhdpi : 2.0
	   - hdpi : 1.5
	   - mdpi : 1.0(baseline)
	   - ldpi : 0.75
	
	만약 xhdpi 장치에 200x200 이미지를 생성한다면 hdpi에는 150x150, mdpi에는 100x100, ldpi 장치에는 75x75 이미지를 생성하면 된다.

	```
	MyProject/
		res/
			drawable-xhdpi/
				awesomeimage.png
			drawable-hdpi/
				awesomeimage.png
			drawable-mdpi/
				awesomeimage.png
			drawable-ldpi/
				awesomeimage.png
	```

	`ldpi 자원은 반드시 필요하지 않다. 시스템이 hdpi 자원으로부터 1/2로 줄여서 생성할 수 있기 때문이다.`

	- 다양한 언어 지원
	UI에 사용되는 문자열들을 코드에서 분리하여 외부 파일에 저장하는 것을 좋은 생각이다.
	안드로이드에서는 자원 디렉터리가 있어서 이것을 쉽게 할 수 있다.
	많은 언어를 지원하기 위해서는 res 안에 values 디렉터리를 생성하면 된다.
	디렉터리 뒤에는 ISO 언어 코드를 붙인다.
	예를 들어서 value-es는 언어 코드가 "es"인 자원을 포함하고 있는 디렉터리이다.

	```
	MyProject/
		res/
			values/
				strings.xml
			values-es/
				strings.xml
			values-fr/
				strings.xml
	```

	실행 시간에 안드로이드는 사용자의 장치에 설정된 로캘값을 가지고 적절한 문자열을 찾게 된다.
	예를 들어서 영어로 된 문자열은 /values/strings.xml에 다음과 같이 저장된다.

	```
	<?xml version="1.0" encoding="utf-8"?>
	<resources>
		<string name="title">My Application</string>
		<string name="hello_world">Hello World!</string>
	</resources>
	```

	```
	참고 : 우리가 장치를 사용하다보면 실행 시간 중에 장치의 구성이 변경되는 경우가 있다.
	예를 들어서 화면 방향이 변경된다든지, 키보드나 언어가 변경될 수 있다.
	이러한 변경이 일어나는 경우, 안드로이드는 실행 중인 액티비티를 다시 시작한다.
	즉 액티비티의 onDestroy()가 호출되고, 그 다음에 onCreate()가 다시 호출된다.
	이러한 재시작 동작은 우리가 제공한 대체 리소스로 애플리케이션을 자동으로 다시 적재함으로써 새로운 장치의 구성에 애플리케이션이 적응하도록 한다.
	예를 들어서 화면의 방향이 변경되면 다른 레이아웃을 적용한다.
	이러한 액티비티 재시작을 올바르게 처리하려면 정상적인 액티비티 생명 주기를 통해 이전 상태를 복원하는 것이 중요하다.
	안드로이드는 onSaveInstanceState()를 호출한 다음에 액티비티를 소멸시켜 애플리케이션 상태에 대한 데이터를 저장할 수 있다.
	이후에 액티비티가 재시작되면 onCreate()나 onRestoreInstanceState() 메소드를 통하여 이전 상태를 복원할 수 있다.
	```

5. 지역화
	지역화라고 하는 것은 문자열이나 통화, 이미지 같은 여러가지 리소스들을 사용자가 있는 지역에 따라 변경하는 것이다.
	안드로이드는 다양한 지역에서 사용되기 때문에 지역에 따라서 애플리케이션 안에 내장된 텍스트, 오디오 파일, 숫자 표시 방법, 통화, 그래픽 등을 변경하는 것이 바람짐하다.
	예를 들어서 한국에서는 "안녕하세요"라는 텍스트를 사용하고 북미권에서는 "Hello"라는 텍스트를 사용하는 것이 사용자에게 보다 친근할 것이다.
	��역화를 쉽게 하려면 모든 리소스와 코드를 분리하여서 정의하여야 한다.
	다음과 같은 원칙을 지키도록 하자.
	   - 애플리케이션의 사용자 인터페이스의 모든 콘텐츠는 코드와 분리시켜서 리소스 파일에 둔다.
	   - 사용자 인터페이스의 동작은 자바 코드에 의해서 이루어지게 한다.
		예를 들어서 사용자가 지역에 따라 다른 방법으로 입력을 해야 한다면 이것은 자바 코드를 이용하여서 처리한다.
	
	- 안드로이드에서의 리소스 스위칭
	앞에서 설명한 대로 리소스는 텍스트, 레이아웃, 사운드, 그래픽 등을 의미한다.
	애플리케이션은 다양한 장치 구성에 대응되는 여러 개의 리소스 집합을 가질 수 있다.
	사용자가 애플리케이션을 실행하면, 안드로이드는 자동으로 장치에 가장 잘 맞는 리소스를 선택하고 적재한다.
	
	```
	- 애플리케이션을 작성할 때:
	기본 리소스를 먼저 정의하고 또 다양한 지역에서 사용되는 대체 리소스를 생성한다.
	            ↓
	- 애플리케이션을 실행할 때:
	안드로이드 시스템은 장치의 지역에 따라 어떤 리소스를 적재할 것인지를 선택한다.
	```

	- 기본 리소스가 중요한 이유
	개발자가 리소스를 제공하지 않은 언어권에서 애플리케이션이 실행되면, 안드로이드는 무조건 기본 리소스를 res/values/strings.xml에서 적재한다.
	만약 이 기본 리소스가 생략되면 애플리케이션은 실행될 수 없다.
	간단한 예를 들어 설명하여 보자.
	애플리케이션의 자바 코드에서 text_a와 text_b라는 2개의 문자열을 사용한다.
	이 애플리케이션은 text_a와 text_b를 영어로 정의하는 지역화된 리소스 파일(res/values-en/strings.xml)을 포함하고 있다.
	또 기본 리소스 파일(res/values-en/strings.xml)도 가지고 있는데 여기서 text_a는 정의되어 있지만 text_b는 정의되어 있지 않다고 가정하자.
	이 애플리케이션을 컴파일할 때는 아무런 문제가 발생하지 않는다.
	또 애플리케이션이 지역이 English로 설정된 장치에서 실행될 때도 역시 문제가 발생하지 않는다.
	하지만 English가 아닌 다른 지역으로 설정된 장치에서는 애플리케이션이 전혀 실행되지 않는다.
	이러한 상태를 예방하기 위하여 res/values/strings.xml 파일 안에 필요한 모든 리소스들을 먼저 정의하여야 한다.

	- 지역화의 예
	예를 들어 애플리케이션의 기본 언어가 영어라고 하자.
	하지만 프랑스어와 한국어로도 애플리케이션을 출시하려고 한다.
	프랑스어로는 모든 것을 번역하고 한국어로는 애플리케이션의 제목을 제외한 모든 것을 번역하기를 원한다.
	이런 경우에는 다음과 같이 리소스 폴더를 생성하면 된다.
	
	```
	폴더/내용
	res/values/strings.xml		애플리케이션이 사용하는 모든 문자열의 영어 버전이 들어 있다.
	res/values-fr/strings.xml	애플리케이션이 사용하는 모든 문자열의 프랑스어 버전이 들어 있다.
	res/values-ko/strings.xml	애플리케이션이 사용하는 모든 문자열 중에서 제목만을 제외하고 나머지 문자열의 한국어 버전이 들어 있다.
	```
	
	만약 자바 코드에서 애플리케이션의 제목을 R.string.title과 같이 참조를 한다면 실행 시간에 다음과 같이 리소스를 가져온다.
	   - 만약 장치의 언어가 프랑스어가 아니면 res/values/strings.xml 파일에서 애플리케이션의 제목을 가져온다.
	   - 만약 장치의 언어가 프랑스어로 설정되어 있으면 res/values-fr/strings.xml 파일에서 애플리케이션의 제목을 가져온다.
	   - 만약 장치의 언어가 한국어로 설정되어 있으면 res/values-ko/strings.xml 파일을 찾을 것이다.
	   하지만 이 파일 안에 제목이 포함되어 있지 않으므로 안드로이드는 기본 리소스 파일로 되돌아가고 결국 res/values/strings.xml 파일에서 영어로 된 제목을 적재하게 된다.

	- 우선순위
	만약 많은 리소스 파일들이 장치의 구성과 일치된다면 안드로이드는 미리 정해진 우선순위를 따라서 어떤 파일을 사용할 것인지를 결정한다.
	리소스 디렉터리의 많은 이름 중에서 제일 먼저 지역(locale)부터 선택한다.
	이것은 앞에서 나왔던 우선순위 표와 동일하다.
	예를 들어서 설명하여 보자.
	애플리케이션이 기본 리소스를 가지고 있고 장치의 설정에 따라서 최적화된 두 개의 대체 리소스를 추가로 제공한다.
	
	```
	- res/drawable/	☜ 디폴트 그래픽 파일들이 포함되어 있다.
	- res/drawable-small-land-stylus/ ☜ 스타일러스를 사용하고 QVGA 저밀도 화면을 가로 방향으로 사용하는 장치를 위한 그래픽 파일들을 포함하고 있다.
	- res/drawable-ko/ ☜ 한국어에 최적화된 그래픽 파일들을 포함하고 있다.
	```

	만약 애플리케이션이 언어를 한국어로 설정된 장치에서 실행된다면, 안드로이드는 그래픽 파일들을 res/drawabe-ko/에서 적재한다.
	이것은 장치가 스타일러스와 QVGA 저밀도 가로 방향 화면을 가지고 있어도 마찬가지이다.
	
6. 보안
	어떤 시스템에서도 보안은 중요하다.
	안드로이드에서도 애플리케이션이 마음대로 시스템이나 다른 애플리케이션을 건드릴 수 있다면 그것은 심각한 위협이 될 것이다.
	안드로이드는 어떤 보안 정책을 사용할까?
	가장 기본적인 보안은 애플리케이션에 할당되는 사용자 아이디와 그룹 아이다와 같은 표준 리눅스 장치들이다.
	안드로이드에서 각 애플리케이션은 자신의 프로세스 안에서 실행된다.
	즉 하나의 애플리케이션은 리눅스의 하나의 사용자로 간주되고 리눅스에서 사용자는 운영체제 시스템이나 다른 사용자의 파일에 접근할 수 없다.
	안드로이드에서 추가적인 세밀한 보안은 권한(permission) 메커니즘을 통하여 제공된다.
	권한은 특정 프로세스가 수행할 수 있는 동작을 제약한다.
	또 URI마다 권한을 줄 수 있고 이 권한을 통하여 데이터의 특정한 부분에 대한 접근을 제어할 수 있다.

	- 보안 구조
	안드로이드 보안 구조의 핵심적인 설계 포인트는 어떠한 애플리케이션도 다른 애플리케이션에 해를 가할 수 있는 동작을 수행할 수 없도록 되어 있다는 점이다.
	즉 다른 애플리케이션의 사적인 데이터를 읽고 쓰는 것, 다른 애플리케이션의 파일이나 네트워크에 접근하는 것도 금지되어 있다.
	이렇게 리눅스 커널이 애플리케이션들을 샌드박스화하여서 서로 고립시키기 때문에 애플리케이션이 어떤 리소스와 자료를 공유하려면 이것을 명백하게 선언하여야 한다.
	**샌드박스**란 실행되는 프로그램들을 서로 분리하기 위한 보안 메커니즘이다.
	안드로이드에서 애플리케이션이 필요한 리소스와 자료에 접근하려면 반드시 권한을 선언하여야 한다.
	애플리케이션은 필요한 권한을 정적으로 선언하고 안드로이드는 애플리케이션이 설치될 때에 사용자에게 이것을 알리고 동의를 받는다.
	반면에 안드로이드는 실행 시간에 동적으로 권한을 승인하는 메커니즘을 가지고 있지 않다.

	- 애플리케이션 서명
	모든 안드로이드 애플리케이션(.apk 파일)은 인증서로 서명된다.
	이때 개인키는 개발자가 보관한다.
	이 인증서는 애플리케이션의 작성자가 식별한다.
	인증서는 다른 인증기관에 의하여 서명될 필요는 없다.
	셀프-서명된 인증서를 사용하는 것도 허용된다.
	인증서는 오직 애플리케이션 간의 신뢰 있는 관계를 구축하기 위하여 사용된다.
	인증서는 애플리케이션이 인증서 기반의 권한에 접근할 때 시스템이 이를 승인하거나 거부할 때 사용된다.

	```
	참고사항 : 샌드박스란 외부로부터 들어온 프로그램이 보호된 영역에서 동작해 시스템이 부정하게 조작되는 것을 막는 보안 형태이다.
	기본적으로 프로그램을 보호된 영역 안에 가둔 뒤 작동시키는 방법으로 프로그램이 폭주하거나 악성 바이러스의 침투를 막는다.
	기술적으로 디스크와 메모리에 스크래치 공간과 같은 엄격하게 제어되는 공간을 제공하여 프로그램이 여기에서만 실행되도록 한다.
	네트워크 접근이나 호스트 시스템을 검사할 수 있는 기능은 제한된다.
	```

	```
	참고사항 : 애플리케이션을 다른 애플리케이션과 분리하는 책임은 전적으로 리눅스 커널이 담당한다.
	달빅 가상 머신 안에서는 보안 정책이 없다.
	따라서 어떤 애플리케이션도 Android NDK를 통하여 네이티브 코드를 실행할 수 있기 때문이다.
	```

	- 사용자 아이디와 파일 접근
	설치 시에 안드로이드는 각 안드로이드 패키지에 유일한 리눅스 사용자 아이디를 부여한다.
	이 아이디는 패키지가 장치에 설치되어 있는 동안에 변경되지 않는다.
	같은 패키지라고 하여도 장치가 다르면 사용자 아이디는 달라진다.
	동일한 장치에서도 각각의 패키지는 유일한 사용자 아이디를 갖는다.
	프로세스 수준에서 각 애플리케이션이 분리되기 때문에, 애플리케이션이 다르면 같은 프로세스 안에서 실행될 수 없다.
	즉 각각의 애플리케이션은 다른 리눅스 사용자로 실행된다.
	하지만 각 패키지의 매니페스트 파일 안에서 sharedUserID 어트리뷰트를 사용하면 같은 사용자 아이디를 공유할 수도 있다.
	이 기능을 사용하면 2개의 패키지가 동일한 애플리케이션처럼 취급된다.
	보안을 유지하기 위해서는 동일한 사용자 아이디를 공유하려면 동일한 인증서로 서명되어야 한다.
	애플리케이션이 생성한 파일은 그 애플리케이션의 사용자 아이디가 부여되기 때문에 일반적으로는 다른 패키지가 접근할 수 없다.
	다른 패키지가 접근하는 것을 허용하려면 getSharedPreferences(), openFileOutput(), openOrCreateDatabase() 등을 이용하여서 새로운 파일을 생성하고 MODE_WORLD_READABLE 또는 MODE_WORLD_WRITEABLE 플래그를 사용하여서 다른 패키지가 그 파일을 읽고 쓸 수 있도록 하여야 한다.

7. 권한 요청하기
	기본적으로 안드로이드 애플리케이션은 어떠한 권한을 가지지 않는다.
	즉 고의적으로 다른 사용자나 장치의 데이터에 어떠한 동작도 할 수 없다.
	만약 애플리케이션이 보호된 기능이나 장치 안의 데이터에 접근하려면 AndroidManifest.xml 파일에 필요한 권한을 나타내는 태그 <uses-permission>을 명시적으로 포함시켜야 한다.
	예를 들어서 문자 메시지를 받고 싶은 애플리케이션은 다음과 같이 권한을 표시할 수 있다.
	
	```
	AndroidManifest.xml
	
	<?xml version="1.0" encoding="utf-8"?>
	<manifest xmlns:android="http://schemas.android.com/apk/res/android"
		package="kr.co.company.PermissionTest"
		android:versionCode="1"
		android:versionName="1.0" >
	...
	<uses-permission android:name="android.permission.RECEIVE_SMS></uses-permission> ☜ 문자 메시지를 받을 수 있는 권한을 요청한다.
	</manifest>
	```

	애플리케이션 설치 시에 애플리케이션이 요구된 권한이 패키지 설치자에 의하여 승인된다.
	패키지 설치자는 애플리케이션의 인증서를 살펴보거나 사용자에게 허락을 구한다.
	만약 권한이 승인되면 애플리케이션은 원하는 데이터들을 사용할 수 있다.
	안드로이드 이전 버전에서는 앱 설치시에만 권한을 승인할 수 있었으나 최신 버전에서는 앱의 실행 전에 권한을 다시 승인받도록 할 수 있다.
	그렇다면 우리가 요청할 수 있는 권한은 어떤 것들이 있는가?
	전체 권한 리스트는 다음의 웹페이지에 나열되어 있다.
	
	`http://developer.android.com/reference/android/Manifest.permission.html`

	중요한 것만을 추리면 다음 표와 같다.

	```
	권한			/	권한 이름		/	설명
	지리 정보 사용		/	ACCESS_FINE_LOCATION	GPS와 같은 정밀한 위치 정보 사용
	전화 걸기		/	CALL_PHONE		애플리케이션이 전화 걸기 기능 사용
	카메라			/	CAMERA			카메라 기능 사용
	일정 정보		/	READ_CALENDAR		일정 정보 읽기
				/	WRITE_CALENDAR		일정 정보 쓰기
	연락처 정보		/	READ_CONTACTS		연락처 읽기
				/	WRITE_CONTACTS		연락처 쓰기
	인터넷			/	INTERNET		인터넷 접속
	```

---
## **10. 서비스와 방송 수신자**

1. 서비스
	애플리케이션을 작성하다 보면 사용자 인터페이스 없이 백그라운드에서 실행되는 동작이 필요한 경우가 종종 있다.
	예를 들어서 배경 음악을 재생한다든지, 특정한 웹사이트에서 주기적으로 데이터를 읽어온다든지, 주기적으로 폰의 사용량을 계산한다든지, 애플리케이션의 업데이트를 주기적으로 검사할 수도 있다.
	이런 경우에 사용할 수 있는 기능이 서비스이다.

	서비스는 액티비티, 방송 수신자, 콘텐트 제공자와 함께 애플리케이션을 구성하는 컴포넌트 중의 하나이다.
	만약 여러분이 안드로이드 폰을 가지고 있다면 [설정] -> [기기] -> [앱] -> [실행 중] 메뉴를 선택하면 안드로이드 폰 안에서 현재 실행되고 있는 서비스들을 볼 수 있다.
	
	서비스는 액티비티와는 달리, 사용자 인터페이스를 가지지 않는다.
	서비스는 일반적으로 애플리케이션에 의하여 시작된다.
	한번 시작된 서비스는 사용자가 다른 애플리케이션으로 이동하더라도 계속하여서 배경(background)에서 실행된다.
	서비스를 이용하면 프로세스 간 통신(IPC:interprocess coummunication)기능도 구현할 수 있다.
	서비스는 네트워크 트랜잭션이나 음악 재생, 파일 입출력, 콘텐츠 제공자와의 통신을 위하여 주로 사용된다.

	- 서비스의 종류
	서비스는 일단 시작되면 무한정 실행될 수도 있고(unbounded), 아니면 서비스를 시작한 액티비티가 실행되고 있는 동안에만 실행될 수도 있다(bounded).

	   - 시작 타입 서비스(started service)
	   액티비티가 startService()를 호출하여서 서비스를 시작하면 시작 타입 서비스가 된다.
	   이러한 서비스는 한번 시작되면 백그라운드에서 무한정 실행될 수 있다.
	   서비스를 시작한 액티비티가 소멸되더라도 마찬가지이다.
	   하지만 보통은 처리를 완료하면 스스로 자신을 종료시킨다.
	   시작 타입 서비스는 호출자에게 결과를 반환할 수 없다.
	   예를 들어서 네트워크에서 파일을 다운로드하거나 업로드 하는 기능은 시작 타입 서비스로 구현된다.

		- 연결 타입 서비스(bound service)
		액티비티가 bindService()를 호출하여서 서비스를 시작하면 연결 타입 서비스가 된다.
		연결 타입 서비스는 클라이언트-서버와 같이 동작한다.
		액티비티는 서비스에 어떤 요청을 전송하고 결과를 받을 수 있다.
		또한 프로세스 간의 통신에도 사용이 가능하다.
		연결 타입 서비스는 액티비티와 연결되어 있는 동안에만 실행된다.
		만약 서비스에 연결된 액티비티가 사라지게 되면 서비스도 소멸된다.
		하나의 서비스에는 다수의 액티비티가 연결될 수 있다.
		
		```
		주의!

		서비스는 2가지 방법으로 동시에 작동될 수도 있다.
		즉 시작 타입 서비스이면서 연결 타입 서비스로도 동작할 수 있다.
		이런 식으로 동작하려면 몇 개의 콜백 메소드를 동시에 구현하면 된다.
		즉 컴포넌트가 시작하는 것을 허용하려면 onStartCommand()를 구현하고 연결을 허용하려면 onBind()를 구현하면 된다.
		```
		
		서비스도 액티비티와 마찬가지로 인텐트 객체를 이용하여서 시작한다.
		이것은 서비스가 시작 타입이건 연결 타입이건 마찬가지이다.
		그리고 서비스는 매니페스트 파일 안에 공용으로 선언되어야 사용이 가능하다.
		만일 매니페스트 파일에서 서비스를 전용으로 선언하면 다른 애플리케이션에서는 그 서비스에 접근할 수 없다.
		
		서비스는 서비스를 호출한 프로세스의 메인 스레드 안에서 실행된다.
		즉 서비스는 새로운 스레드로 실행되지 않는다.
		따라서 만약 CPU를 많이 사용하는 작업의 경우에는 서비스 안에서 새로운 스레드를 생성하는 것이 좋다.
		예를 들어서 MP3파일 재생이나 네트워킹과 같은 작업이 여기에 해당된다.
		별도의 스레드를 사용함으로써 ANR(Application Not Responding)과 같은 오류를 줄일 수 있고 메인 스레드는 사용자 상호작용에만 전념할 수 있다.

		```
		서비스를 사용할 것인가 아니면 스레드를 사용할 것인가?

		서비스는 사용자가 애플리케이션과 상호작용하고 있지 않더라도 백그라운드에서 실행되는 컴포넌트이다.
		따라서 만약 이것이 개발자가 원하는 것이면 당연히 서비스를 생성하여야 한다.
		만약 사용자가 애플리케이션과 상호작용하고 있는 동안에만 메인 스레드 외부에서 작업을 하는 것이 필요하면 새로운 스레드를 생성하는 것이 바람직하다.
		예를 들어서 액티비티가 실행되고 있는 동안에만 음악을 재생하는 것이 필요하면 onCreate()에서 스레드를 생성하고 onStart()에서 스레드를 시작하고 onStop()에서 중지하면 된다.
		```

2. 서비스 기초
	서비스는 Service란 클래스를 상속받아서 작성한다.
	Service 클래스 안의 몇 개의 메소드를 재정의해주면 된다.
	서비스가 시작되거나 서비스가 종료될 때에 이들 콜백 메소드들이 호출된다.
	또 컴포넌트가 서비스에 연결할 때도 호출된다.
	재정의 해야 할 몇 개의 중요한 메소드를 살펴보자.

	```
	public class MyService extends Service {
		@Override
		public int onStartCommand(Intent intent, int flags, int startId) {
			...
		}
		/* 다른 컴포넌트가 startService()를 호출하여서 서비스가 시작되면 이 메소드가 호출된다.
		 * 작업이 완료되었을 경우에 stopSelf()나 stopService()를 호출하여서 서비스를 종료하여야 한다.
		 * 그렇지 않으면 무한정 실행된다.
		 * 만약 연결 타입 서비스를 구현한다면 이 메소드는 재정의할 필요가 없다.
		 */
		
		@Override
		public IBinder onBind(Intent intent){
			...
		}
		/* 다른 컴포넌트가 bindService()을 호출하여서 서비스와 연결을 시도하면 이 메소드가 호출된다.
		 * 이 메소드 안에서 개발자는 IBinder을 반환해 통신하는 데 사용하는 인터페이스를 제공해야 한다.
		 * 만약 연결을 원치 않으면 null을 반환하면 된다.
		 */

		@Override
		public void onCreate(){
			...
		}
		/* 서비스가 처음으로 생성되면 호출된다.
		 * 이 메소드 안에서는 초기의 설정 작업들을 수행하면 된다.
		 * 서비스가 이미 실행되고 있는 경우에는 이 메소드는 호출되지 않는다.
		 */

		@Override
		public void onDestory(){
			...
		}
		/* 서비스가 소멸되는 도중에 이 메소드가 호출된다.
		 * 개발자는 반드시 이 메소드를 구현하여야 하는데 주로 스레드나 리스너, 수신자와 같은 자원들을 정리하는 데 사용하면 된다.
		 * 이 메소드 호출이 서비스 생애 주기에서 마지막 호출이 된다.
		 */
	}
	```
	
	먼저 음악을 연주하는 서비스를 작성하고 이어서 이 서비스를 사용하는 액티비티를 제작하여 본다.
	액티비티에서 서비스를 시작하려면 startService()를 호출하면 된다.
	이 서비스는 시작 타입의 서비스가 된다.

	- 서비스의 생애주기
	만약 startService()를 호출하여서 서비스를 시작하였다면 서비스는 stopSelf()를 호출하거나 다른 컴포넌트가 stopService()를 호출할 때까지 실행을 계속한다.

	![Image](service.png)

	만약 컴포넌트가 bindService()를 호출하여서 서비스를 시작하였다면 서비스는 컴포넌트가 서비스에 연결되어 있는 동안에만 실행된다.
	서비스에 연결된 모든 클라이언트들이 접속을 해제하면 해당 서비스는 소멸된다.

	- 서비스에서 사용자에게 통지하기
	서비스는 실행 중에 토스트나 상태바를 사용하여서 사용자에게 이벤트를 통지할 수 있다.
	토스트는 현재 윈도우 상태 메시지가 나타났다가 사라지는 형태이고, 상태바는 상태바에 메시지와 함께 아이콘이 생성되는 것이다.
	사용자는 아이콘을 눌러서 필요한 액티비티를 실행할 수 있다.
	일반적으로 상태바 통지 기법이 좋은 방법이다.
	예를 들어서 파일 다운로드가 완료되었을 경우에는 상태바를 이용하여서 통지하는 것이 좋다.
	사용자는 상태바를 통하여 반응할 수 있다.
	사용자가 상태바에서 통지를 선택하면 통지는 새로운 액티비티를 시작할 수 있다.
	예를 들어서 다운로드된 파일을 볼 수 있다.
	보다 자세한 내용은 상태바 통지를 참고하여야 한다.

	- 서비스를 전경에서 실행하기
	전경에서 실행되는 서비스는 사용자의 입장에서 상당히 중요한 것으로 여겨지는 서비스이다.
	따라서 시스템에 메모리가 부족하다고 해서 중단되서는 안된다.
	전경 서비스는 반드시 상태바에 "진행중"이라는 이름 아래에 통지를 제공하여야 한다.
	이것은 서비스가 중단되거나 전경에서 삭제되지 않는 한 통지는 반드시 있어야 한다는 의미이다.
	
	예를 들어서 음악을 재생하는 음악 재생기는 전경에서 실행되도록 설정되어야 한다.
	왜냐하면 사용자가 명시적으로 음악 재생기의 동작을 의식하고 있기 때문이다.
	상태바의 통지는 현재 노래의 제목을 표시할 수 있다.
	또 통지를 터치하면 사용자가 상호작용할 수 있는 액티비티를 실행할 수 있어야 한다.
	
	서비스가 전경에서 실행되게 하려면 startForeground()를 호출한다.
	이 메소드는 2개의 매개변수를 가진다.
	매개변수는 통지의 아이디와 상태바를 위한 Notification 객체이다.
	예를 들면 다음과 같다.

	```
	Notification notification = new Notification(R.drawable.icon, getText(R.string.ticker_text), System.currentTimeMillis());
	Intent notificationIntent = new Intent(this, ExampleActivity.class);
	PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
	notification.setLatestEventInfo(this, getText(R.string.notification_title), getText(R.string.notification_message), pendingIntent);

	startForeground(ONGOING_NOTIFICATION_ID, notification);
	```

	서비스를 전경으로부터 삭제하고 싶으면 stopForeground()를 호출한다.
	이 메소드는 부울값을 받는데, 상태바 통지를 삭제할 것인지를 나타낸다.
	이 메소드가 서비스를 중지하지 않는다.
	하지만 전경에서 실행되고 있는 동안에 개발자가 서비스를 중단하면 통지도 삭제된다.

3. IntentService 클래스
	앞 절에서는 Service 클래스를 상속받아서 서비스를 작성하였다.
	시작 타입의 서비스를 생성하기 위해서는 일반적으로 다음과 같은 두 가지 클래스를 상속받을 수 있다.

	- Service 클래스
		이 클래스는 모든 서비스의 부모클래스이다.
		이 클래스를 상속받아서 서비스를 작성할 때에는 주의할 점이 있다.
		만약 서비스에서 하는 작업이 상당히 시간을 요구한다면 서비스 안에서 새로운 스레드를 생성하는 것이 좋다.
		왜냐하면 그렇지 않으면 서비스가 애플리케이션의 메인 스레드를 사용하게 되고 따라서 애플리케이션이 실행되는 속도를 더디게 할 수 있기 때문이다.

	- IntentService 클래스
		이 클래스는 시작 요청이 들어올 때마다 이것을 처리하는 작업 스레드를 별도로 생성한다.
		이 클래스는 서비스가 다중 요청을 동시에 처리할 필요가 없다면 가장 좋은 선택이 된다.

		```
		IntentService 클래스의 장점

		IntentService 클래스에서는 콜백 메소드에 대하여 디폴트 구현을 제공한다.
		따라서 개발자가 별도로 콜백 메소드를 구현할 필요가 없다.
		개발자는 단지 결론적으로 개발자가 구현해야 할 메소드는 onHandleIntent()이고 여기에서 클라이언트가 요청한 작업을 하면 된다.
		또 요청이 처리되면 자동적으로 서비스를 중단한다.
		따라서 stopSelf()를 호출할 필요가 없다.
		```

4. 연결 타입 서비스
	연결 타입 서비스는 클라이언트-서버에서 서버의 역할을 할 수 있다.
	컴포넌트들은 서비스에 연결해서 요청을 보내고, 서비스는 요청에 대한 결과를 컴포넌트로 전송한다.
	연결 타입 서비스를 이용하면 프로세스 간 통신(interprocess communication)도 가능하다.
	연결 타입 서비스는 컴포넌트와 연결되어 있는 동안에만 존재한다.
	따라서 시작 타입 서비스와는 다르게 백그라운드에서 무한히 실행되지 않는다.
	연결 타입 서비스는 애플리케이션 안의 기능을 외부에 제공하는 경우에 많이 사용된다.

	- 연결 타입 서비스 생성하기
	만약 컴포넌트가 bindService()를 호출하여서 서비스에 연결하는 서비스를 연결된 타입의 서비스라고 한다.
	연결된 타입의 서비스를 생성하려면 콜백 메소드인 onBind()를 구현하여야 한다.
	onBind()는 IBinder를 반환하는데 이것이 서비스와 클라이언트 사이의 인터페이스를 정의한다.
	연결된 타입의 서비스를 이용하려면 어떻게 클라이언트들이 서비스와 통신할 것인지를 정의하는 인터페이스가 필요하다.
	클라이언트가 bindService()를 호출하면 클라이언트가 서비스에 연결되면서 IBinder가 반환된다.
	클라이언트가 IBinder를 받으면 이 인터페이스를 통하여 서비스와 상호작용을 시작할 수 있다.
	즉 서비스가 제공하는 다른 메소드들을 호출할 수 있다.
	여러 클라이언트들이 하나의 서비스에 동시에 접속할 수 있다.
	클라이언트가 서비스와 상호작용을 끝내면 unbindService()를 호출한다.
	만약 서비스에 연결된 클라이언트가 하나도 남아있지 않으면 안드로이드 시스템이 서비스를 소멸시킨다.


	- 서비스의 인터페이스를 정의하는 3가지 방법
		- Binder 클래스 확장하기
			만약 서비스가 애플리케이션 내에서만 사용된다면 서비스의 인터페이스를 Binder클래스를 확장하여서 정의하고 onBind()가 호출되었을 때, 그 클래스의 인스턴스를 반환할 수 있다.
			클라이언트는 Binder 객체를 통하여 서비스 안의 메소드를 직접 호출할 수 있다.
			이 방법은 주로 서비스가 애플리케이션 내에서 백그라운드 작업을 담당하는 경우에 선호된다.

		- Messenger 클래스 사용하기
			다른 프로세스들이 서비스를 사용한다면 Messenger를 사용하여서 인터페이스를 생성할 수 있다.
			서비스는 다양한 종류의 Message 객체에 응답하는 Handler를 정의한다.
			이 Handler가 Message의 기초가 된다.
			이 방법은 프로세스 간 통신을 구현하는 가장 간단한 방법이다.

		- Using AIDL
			AIDL(Android Interface Definition Language)은 객체를 운영체제가 이해할 수 있는 기초 단위로 분해하고 IPC를 수행하도록 이들을 프로세스 사이에서 주고받는 모든 작업을 한다.
			앞의 Messenger도 사실 AIDL에 기반을 두고 있다.
			AIDL을 직접 사용하려면 인터페이스를 정의하는 .aidl 파일을 생성하여야 한다.
			안드로이드 SDK 도구가 이 파일을 이용하여서 추상 클래스를 생성한다.

		예제 실습 해보자

5. 방송 수신자란?
	안드로이드 장치에서는 많은 이벤트들이 발생한다.
	배터리가 부족할 수도 있고 네트워크 연결이 끊어질 수도 있고 SD카드가 삽입되거나 제거될 수도 있다.
	이벤트에 따라서 애플리케이션이 반드시 알아야 하는 이벤트도 존재한다.
	예를 들어서 SD카드에 데이터를 저장하는 애플리케이션은 SD카드의 상태가 변경되면 이를 통지해 주기를 바랄 것이다.
	안드로이드에서는 이러한 이유 때문에 방송 수신자(Broadcast Receiver)라는 메커니즘을 제공한다.

	애플리케이션이 방송을 수신하기 위해서는 방송 수신자를 작성하면 된다.
	방송 수신자는 애플리케이션을 구성하는 4가지 컴포넌트 중의 하나이다.
	방송 수신자는 다음과 같이 BroadcastReceiver라는 클래스를 상속받아서 작성하면 된다.

	```
	public class MyBroadcastReceiver extends BroadcastReceiver
	{
		public void onReceive(Context context, Intent intent){
			...
			...
		}	
	}
	```

	이때 onReceive()라는 메소드를 재정의하게 되는데 방송이 수신되면 이 메소드가 호출된다.
	따라서 여기에 필요한 코드를 넣으면 된다.
	onReceive()의 매개변수인 context는 방송 수신자가 실행되는 컨텍스트이고, 매개변수 intent를 통하여 방송에 대한 자세한 내용이 전달된다.
	intent의 액션에 방송의 종류가 들어 있고 intent의 필드에 추가 정보가 저장되어 있다.

	방송 수신자도 액티비티처럼 애플리케이션을 구성하는 4가지 컴포넌트 중의 하나이므로 반드시 매니페스트 파일에 선언하여야 한다.
	또 어떤 방송을 받을 것인지를 반드시 인텐트 필터를 통하여 지정하여야 한다.
	예를 들어서 전송되는 문자 메시지를 받고 싶으면 다음과 같이 매니페스트 파일을 작성하면 된다.

	```
	<receiver android:name="MyBroadcastReceiver" >
		<intent-filter>
			<action android:name="android.provider.Telephony.SMS_RECEIVED" />
		</intent-filter>
	</receiver> 
	```

	- 방송 수신자의 동적 생성
	방송 수신자는 일반적으로 매니페스트 파일에 <receiver> 태그를 사용하여서 정적으로 생성되는 것이 일반적이다.
	하지만 경우에 따라서는 액티비티 안에서 동적으로 생성하여서 사용하는 경우도 있다.
	동적으로 생성하는 경우에는 객체 생성 후에 반드시 Context.registerReceiver()를 이용하여서 등록하여야 한다.
	액티비티의 onResume() 메소드에서 생성하고 onPause()에서 등록을 해제하면 액티비티가 화면에 보이는 동안에만 방송을 수신할 수 있다.
	이렇게 하면 시스템의 오버헤드를 줄일 수 있다.
	그리고 몇 가지의 액션은 반드시 동적으로 등록해야만 수신할 수 있다.
	예를 들어서 ACTION_BATTERY_CHANGED 같은 액션이 그렇다.

6. 중요한 방송
	방송에 사용되는 액션에는 어떤 것들이 있을까?
	안드로이드 홈페이지의 인텐트 클래스 설명에 자세하게 나와있다.
	액션의 설명에 'Broadcast Action'이 붙어있으면 방송에 사용되는 액션이다.

	LAB

---
## **11. 스레드**

1. 프로세스와 스레드
	- 병렬 작업
	병렬 작업(multi-tasking)은 여러 개의 프로그램을 동시에 실행시켜서 컴퓨터 시스템의 성능을 높이기 위한 기법이다.
	인간의 경우, 음악을 들으면서 동시에 운동을 할 수 있다.
	컴퓨터의 경우에도 파일을 인쇄하면서 동시에 문서를 편집하거나 인터넷에서 파일을 다운로드할 수 있다.
	컴퓨터에 CPU가 하나만 있어도 병렬 작업은 가능하다.
	운영체제가 CPU의 시간을 각 프로세스에 할당하여서 작업들이 동시에 수행되는 것처럼 보이게 하기 때문이다.

	안드로이드는 다중 스레딩(multi-threading)을 지원한다.
	즉 하나의 애플리케이션은 동시에 여러가지 작업을 할 수 있다.
	안드로이드는 자바의 다중 스레딩 기능을 그대로 지원한다.
	개발자들은 하나의 애플리케이션 안에 동시에 실행되는 여러 스레드를 만들 수 있으며 이 스레드들은 자바 가상 기계에 의하여 동시에 실행된다.

	- 프로세스와 스레드
	안드로이드에는 프로세스와 스레드라는 2가지의 실행 단위가 있다.
	가장 근본적인 차이점은 프로세스는 자신만의 데이터를 가지는 데 반하여 스레드들은 동일한 데이터를 공유하는 것이다.
	동시에 수행되는 스레드들이 변수를 공유한다는 것은 상당히 위험할 수도 있을 것이다.
	하지만 동시에 변수를 공유함으로써 스레드 간의 통신이 상당히 효율적으로 이루어진다.

	   - 프로세스
	   프로세스는 독자적으로 실행이 가능한 환경이다.
	   프로세스는 자기만의 메모리 공간을 가진다.
	   각각의 프로세스의 메모리 공간은 분리되어 있다.

	   - 스레드
	   스레드는 경량 프로세스라고도 불린다.
	   왜냐하면 스레드를 생성하는 것은 프로세스를 생성하는 것보다 훨씬 부담이 적게 들기 때문이다.
	   스레드들은 프로세스 안에서 존재한다.
	   모든 프로세스에는 적어도 하나의 스레드는 존재한다.
	   스레드들은 메모리와 파일을 포함하여 프로세스의 모든 자원을 공유한다.

	- 안드로이드에서 프로세스와 스레드
	애플리케이션의 컴포넌트가 시작할 때, 애플리케이션의 다른 컴포넌트가 실행되고 있지 않으면 안드로이드 시스템은 새로운 리눅스 프로세스를 생성하고 하나의 스레드로 실행하게 된다.
	기본적으로 애플리케이션 안의 모든 컴포넌트들은 동일한 프로세스의 동일한 스레드로 실행된다.
	이 기본적인 스레드를 메인 스레드라고 부른다.
	만약 애플리케이션의 다른 컴포넌트가 이미 프로세스로 실행되고 있는 경우에는 그 프로세스 안에서 새로운 컴포넌트가 시작되고 스레드를 공유한다.

	하지만 우리는 특정한 컴포넌트가 독립적인 프로세스로 실행되도록 설정할 수도 있고 필요하면 프로세스에 추가적인 스레드도 언제든지 생성하여 추가할 수 있다.

	- 동시 작업의 문제점
	동시 작업 프로그램은 단일 작업 프로그램보다 신경 써야 할 부분이 많은데 그 이유는 동시에 여러 작업들이 같은 데이터를 공유하게 되면 동기화라고 하는 까다로운 문제가 발생하기 떄문이다.
	자바에는 이 문제를 해결할 수 있는 도구들이 포함되어 있다.

2. 스레드
	애플리케이션이 구동되면 안드로이드 시스템은 애플리케이션을 위한 실행 스레드를 생성한다.
	이 스레드는 **메인 스레드**라고 불린다.
	이 메인 스레드는 아주 중요한데 사용자 인터페이스 위젯에 이벤트를 전달하거나 화면을 그리는 작업을 담당하기 때문이다.
	이러한 이유로 메인 스레드는 **UI 스레드**라고도 불린다.

	- 메인 스레드
	안드로이드 시스템은 각각의 컴포넌트를 위하여 별도의 스레드를 생성하지 않는다.
	동일한 프로세스 안에서 실행되는 모든 컴포넌트는 메인 스레드 안에서 실행된다.
	그리고 컴포넌트의 시스템 호출도 그 스레드 안에서 이루어진다.
	결과적으로 onKeyDown()와 같은 사용자 인터페이스와 관련된 콜백 메소드나 생애주기와 관련된 메소드들은 모두 메인 스레드 안에서 실행된다.
	
	예를 들어서 사용자가 화면의 버튼을 터치하면 애플리케이션의 메인 스레드가 터치 이벤트를 위젯에 전달한다.
	위젯은 다시 내부 상태를 눌려진 상태로 변경하고 화면을 다시 그리라는 요청을 전송하고 이 요청은 이벤트 큐에 저장된다.
	메인 스레드는 이 요청을 꺼내서 위젯에 자신을 다시 그리라는 것을 알린다.

	만약 애플리케이션이 많은 작업을 하고 있다면 이러한 단일 스레드 모델은 애플리케이션의 성능을 상당히 떨어뜨릴 수 있다.
	특히 모든 것이 메인 스레드 안에서 이루어진다면 네트워크 접근이나 데이터베이스 쿼리와 같은 시간이 많이 걸리는 작업들을 수행하게 되면 사용자 인터페이스가 멈추어버릴 가능성이 많다.
	메인 스레드가 멈추어버리면 아무런 이벤트도 처리되지 않고 화면을 다시 그리는 작업도 이루어지지 않는다.
	따라서 사용자의 입장에서 보면 애플리케이션이 멈춘 것처럼 보인다.
	만약 메인 스레드가 5초 이상 블록되어 있으면 안드로이드는 "application not responding(ANR)"라고 불리는 대화 상자를 생성하고 애플리케이션을 중지한다.
	
	추가적으로 사용자 인터페이스 툴킷은 스레드-안전(thread-safe)모드가 아니다.
	즉 사용자 인터페이스 부분은 멀티 스레딩에 대하여 안전하지 않다는 의미가 된다.
	메인 스레드가 아닌 다른 스레드가 사용자 인터페이스를 조작하면 문제가 발생할 수 있다는 의미이다.
	반드시 사용자 인터페이스 메인 스레드에서만 조작을 하여야한다.
	따라서 안드로이드의 단일 스레드 모델에서는 다음과 같은 2가지의 중요한 원칙이 존재한다.

	   - UI 스레드는 블록시키면 안된다.
	   - UI 스레드가 아닌 다른 스레드가 UI 툴킷을 조작하면 안된다.

	- 작업 스레드
	앞에서 설명한 대로 메인 스레드를 블록시키지 않는 것이 무엇보다도 중요하다.
	따라서 애플리케이션에서 즉각적으로 결과가 나오지 않고 시간이 많이 걸리는 작업을 할 경우에는 스레드를 별도로 생성하는 것을 고려하여야 한다.
	이러한 목적으로 작성되는 스레드를 작업 스레드라고 한다.

	안드로이드의 스레드 모델은 자바의 스레드 모델을 그대로 따른다.
	자바는 언어 자체에 다중 스레딩 기능이 포함되어 있다.
	자바가 제공하는 다중 스레딩에는 다음과 같은 2가지 방법이 존재한다.
	어떤 방법을 사용하여도 결과는 동일하다.

	   - Thread 클래스를 상속받아서 스레드를 작성하는 방법
	   - Runnable 인터페이스를 구현한 후에 Thread 객체에 전달하는 방법

	- Thread 클래스를 상속받아서 스레드를 작성하는 방법
	이 방법은 Thread 클래스를 확장하여서 작업 스레드를 작성하고 run()메소드를 재정의한 후에 작업 스레드의 객체를 생성하고 start()메소드를 호출하는 것이다.
	
	```
	class WorkerThread extends Thread {
		public void run() {	// 여기에 작업을 기술한다.
			...
		}
	}
	public class ThreadTest extends AppCompatActivity {
		public void onStart()
		{
			...
			w = new WorkerThread();	// 여기서 스레드를 생성하고 시작한다.
			w.start();
		}
	}
	```

	- Runnable 인터페이스를 구현한 후에 Thread 객체에 전달하는 방법
	이 방법은 Runnable 인터페이스를 구현한 클래스를 작성하고 run() 메소드를 재정의 한 후에, 이 클래스의 객체를 Thread 생성자로 전달하는 방법이다.
	Thread 객체를 실제 작업을 수행하는 일꾼으로 생각하고 Runnable 인터페이스를 구현한 클래스는 작업 지시서로 생각하면 이해하기 쉽다.

	```
	class Worker implements Runnable {
		public void run() {
			...
		}
	}

	public class ThreadTest extends Activity {
		public void onStart()
		{
			...
			w = new Thread(new Worker());
			w.start();
		}
	}
	```

3. 스레드에서 UI를 조작하는 방법
	스레드를 사용할 때 항상 주의해야할 점은 스레드에서 직접적으로 사용자 인터페이스 위젯을 변경하면 안된다는 것이다.
	예를 들어서 스레드에서 화면에 표시되는 프로그레스바, 이미지 뷰, 텍스트 뷰 등을 직접 변경하면 안된다.
	왜 그럴까? 다음과 같은 전형적인 코드를 통하여 그 이유를 살펴보다.

	예를 들어서 버튼이 클릭되면 새로운 작업 스레드를 생성하고 이미지를 다운로드 받아서 화면의 이미지 뷰에 표시하는 코드는 다음과 같이 작성할 수 있다.

	```
	public void onClick(View v) {
		new Thread(new Runnable() {
			public void run() {
				Bitmap b = loadImageFromNetwork("http://example.com/image.png");
				mImageView.setImageBitmap(b);	// 스레드 안에서 UI를 조작하면 실행 오류가 발생한다.
			}
		}).start();
	}
	```

	얼핏 보면 아무런 문제가 없어 보인다.
	즉 새로운 스레드를 만들어서 네트워크 작업을 시켰기 때문이다.
	그러나 이 코드는 스레드 사용 시 지켜야 할, 두 번째 원칙을 위반하였다.
	즉 UI스레드가 아닌 다른 스레드에서 UI 툴킷에 접근하지 말라는 원칙을 위배하고 있는 것이다.
	이 예제에서는 UI스레드가 아닌 작업 스레드에서 이미지 뷰를 변경하고 있는 것이다.
	이것은 예상하지 못한 결과를 낳을 수도 있다.
	이것을 디버깅한다는 것은 상당히 어렵고 시간소모적인 작업이 된다.
	이 문제를 해결하기 위해서 안드로이드는 다른 스레드에서 UI스레드에 접근하는 많은 방법을 제공하고 있다.

	   - Activity.runOnUiThread(Runnable)
	   - View.post(Runnable)
	   - View.postDelayed(Runnable, long)

	예를 들어서 View.post(Runnable) 메소드를 사용하여서 이전의 문제를 해결해보면 다음과 같다.

	```
	public void onClick(View v){
		new Thread(new Runnable(){
			public void run(){
				final Bitmap bitmap = loadImageFromNetwork("http://example.com/image.png");
					mImageView.post(new Runnable(){	// 스레드를 이미지뷰의 메시지 큐로 전송한다.
						public void run(){
							mImageView.setImageBitmap(bitmap);
						}
					});
			}
		}).start();
	}
	```

	post() 메소드는 View 클래스의 메소드로 Runnable 객체를 메시지 큐에 추가하게 된다.
	따라서 Runnable 객체가 UI 스레드 위에서 실행된다.
	이 구현은 스레딩에 대하여 안전하다.
	즉 네트워크 작업은 별도의 스레드에서 이루어지고 이미지 뷰는 UI스레드에 의하여 처리된다.

	그러나 작업의 복잡도가 증가할수록 이러한 종류의 코드는 까다로워지며 유지보수하기가 어려워진다.
	작업 스레드와의 복잡한 상호작용을 처리하기 위하여 작업 스레드에서 UI스레드로부터 전달된 메시지를 처리하기 위하여 핸들러(Handler)를 사용하는 것도 좋다.
	아마도 가장 좋은 해결책을 AsyncTask클래스를 상속받아서 사용하는 것이다.
	이것은 사용자 인터페이스와의 상호작용을 위한 작업 스레드의 코드를 간단하게 한다.
	
	- 러너블 객체 전송하는 방법

	- AsyncTask 사용하기
	AsyncTask 클래스는 1.5버전부터 추가된 클래스로 작업 스레드와 관련된 복잡한 부분을 쉽게 처리해주는 클래스이다.
	AsyncTask 클래스는 개발자로 하여금 사용자 인터페이스에 대한 비동기적인 작업을 허용한다.
	이 클래스는 작업 스레드 안에서 주어진 작업을 실행하며 결과를 UI스레드로 전달한다.
	이 과정에서 개발자가 스레드를 처리하거나 핸들러를 만들 필요가 없다.
	
	앞에서 등장하였던 네트워크에서 이미지를 다운받아서 이미지뷰에 표시하는 예제를 AsyncTask클래스로 작성하면 다음과 같다.

	```
	public void onClick(View v) {
		new DownloadImageTask().execute("http://example.com/image.png");
	}

	private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
		/**
		 * doInBackground()에는 작업 스레드에서 수행하여야하는 작업을 기술한다.
		 * 이 메소드는 백그라운드 스레드의 풀에서 작업 스레드를 하나 꺼내서 그 스레드를 이용하여서 실행된다.
		 */
		protected Bitmap doInBackground(String... urls) {
			return loadImageFromNetwork(urls[0]);
		}
		
		/**
		 * 사용자 인터페이스를 업데이트하기 위하여 onPostExecute()를 구현한다.
		 * 이 메소드는 doInBackground()로부터의 결과를 전달받아서 UI 스레드 안에서 실행된다.
		 * 따라서 안전하게 사용자 인터페이스를 업데이트할 수 있다.
		 */
		protected void onPostExecute(Bitmap result){
			mImageView.setImageBitmap(result);
		}
	}
	```

	개발자는 UI 스레드에서 필요할 때마다 execute()를 호출하여서 이 메소드를 실행할 수 있다.
	즉 버튼이 클릭되면 execute()를 호출하여서 사용자 인터페이스를 업데이트할 수 있다.
	중간 단계의 업데이트는 onProgressUpdate()를 사용하면 된다.
	작업 스레드에서 publishProgress()를 호출하면 UI스레드 안에서 onProgressUpdate()가 호출된다.
	AsyncTask 클래스는 AsyncTask<Params, Progress, Result>와 같이 제네릭을 이용하여서 작성되었다.

	   - Params는 실행 시에 작업에 전달되는 값의 타입이다.
	   - Progress는 작업의 진행 정도를 나타내는 값의 타입이다.
	   - Result는 작업의 결과 값을 나타내는 값의 타입이다.

	위의 모든 타입을 모두 사용할 필요는 없다.
	만약 필요하지 않은 타입이 있다면 Void라고 표시해주면 된다.
	
	AsyncTask는 다음과 같은 메소드를 가지고 있다.

	   - doInBackground() 메소드는 작업 스레드에서 자동적으로 실행된다.
	   - onPreExecute(), onPostExecute(), onProgressUpdate()는 UI 스레드에서 실행된다.
	   - doInBackground()가 반환하는 값은 onPostExecute()로 보내진다.
	   - doInBackground() 도중에 언제든지 publishProgress()를 호출하여서 UI 스레드에서 onProgressUpdate()를 실행할 수 있다.
	   - 언제든지 작업을 취소할 수 있다.

	코드에서 doInBackground(URL... urls)와 같이 매개변수 이름에 ...와 같이 마침표 3개를 붙이는 것은 가변 매개변수 기능(varargs)을 사용한 것이다.
	즉 앞의 매개변수만 표시하고 나머지 매개변수는 감추고자할 때 사용된다.

4. 스레드를 이용한 이미지 다운로드
	네트워크로부터 이미지를 다운로드하여 화면에 표시하는 작업은 상당히 많이 사용된다.
	이번 실습에서는 스레드를 이용하여서 URL로부터 이미지를 다운로드하고 이것을 이미지뷰에 표시하여 보자.


5. 게임 예제

---
## **12. 데이터베이스**

1. 데이터를 저장하는 방법
	애플리케이션에서는 상황에 따라서 데이터를 저장할 필요가 발생한다.
	예를 들어서 연락처 애플리케이션이라면 사용자가 입력한 주소와 전화번호를 어딘가에 저장해야 할 것이다.
	안드로이드는 애플리케이션이 데이터를 저장하는 몇 가지 옵션을 제공한다.
	애플리케이션의 상황에 따라서 선택은 달라질 수 있다.
	즉 데이터를 애플리케이션만 사용하느냐 아니면 다른 애플리케이션도 사용하느냐에 따라서 달라지고 또 데이터 용량이 얼마나 큰가에 따라서도 선택이 달라진다.

	안드로이드에서 데이터를 저장하는 방법에는 다음과 같은 것들이 있다.

	```
	공유 프레퍼런스		키-값 쌍으로 사적이고 기초적인 데이터를 저장한다.
	내부 저장			사적인 데이터를 내부 저장소에 저장한다.
	외부 저장			공유 데이터를 공유 외부 저장소에 저장한다.
	SQLite 데이터베이스	구조화된 데이터를 사적인 데이터베이스에 저장한다.
	네트워크 연결		데이터를 네트워크 서버에 저장한다.
	```

	안드로이드는 사적인 데이터라고 하더라도 콘텐트 제공자(content provider)를 통하여 다른 애플리케이션에 제공할 수 있다.
	콘텐트 제공자는 애플리케이션을 구성하는 컴포넌트의 일종으로 애플리케이션이 가지고 있는 데이터를 외부에 제공한다.
	물론 데이터를 읽거나 쓸 수 있는 권한이 있어야 할 것이다.

2. 공유 프레퍼런스
	공유 프레퍼런스(Shared Preferences)는 기초적인 자료형을 키-값 쌍으로 저장하고 복원할 수 있는 방법이다.
	SharedPreferences 클래스를 사용하여 부울형, 실수형, 정수형, 문자열과 같은 기초 자료형들을 저장할 수 있다.
	저장된 데이터는 사용자 애플리케이션이 종료되더라도 저장된다.
	