package domain;

public class ElecDTO {
	//sql문 보고 private으로 세팅할것
	private String modelNum;//1
	private String modelName;//2
	private int price;//3
	private String description;//4
	private String password;//5
	private String writeday;//6
	private int readnum;//7
	private String fname;//8
	private int fsize;//9
	
	public ElecDTO() {}
	
	//삭제할때: 모델번호, pw
	public ElecDTO(String modelNum, String password) {
		super();
		this.modelNum = modelNum;
		this.password = password;
	}
	
	//업로드 안될경우 생성자:모델번호,모델명,가격,상세,pw
	public ElecDTO(String modelNum, String modelName, int price, String description, String password) {
		super();
		this.modelNum = modelNum;
		this.modelName = modelName;
		this.price = price;
		this.description = description;
		this.password = password;
	}
	//업로드가 될때: 전체내용
	public ElecDTO(String modelNum, String modelName, int price, String description, String password, String writeday,
			int readnum, String fname, int fsize) {
		super();
		this.modelNum = modelNum;
		this.modelName = modelName;
		this.price = price;
		this.description = description;
		this.password = password;
		this.writeday = writeday;
		this.readnum = readnum;
		this.fname = fname;
		this.fsize = fsize;
	}

	//getter, setter생성
	public String getModelNum() {
		return modelNum;
	}

	public String getModelName() {
		return modelName;
	}

	public int getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public String getPassword() {
		return password;
	}

	public String getWriteday() {
		return writeday;
	}

	public int getReadnum() {
		return readnum;
	}

	public String getFname() {
		return fname;
	}

	public int getFsize() {
		return fsize;
	}

	public void setModelNum(String modelNum) {
		this.modelNum = modelNum;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}

	public void setReadnum(int readnum) {
		this.readnum = readnum;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setFsize(int fsize) {
		this.fsize = fsize;
	}
	
	
}
