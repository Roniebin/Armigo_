import axios from 'axios'

function Fitting(props)
{
    return(
        <div className="shop-virtual-fitting">
                <div className="virtual-setting">
                  <h4>가상 의류 피팅</h4>
                  <p className="smallfont" style={{ color: "gray" }}>
                    사진을 업로드하고 샘플 이미지를 선택하여 옷을 가상으로
                    착용해 보세요
                  </p>
                  <br></br>
                  <span className="smallfont">사진 업로드</span>

                  <br></br>
                  <div className="file-upload">
                    <input type="file"></input>
                  </div>

                  <br></br>
                  <span className="smallfont">샘플 이미지 선택</span>
                  <br></br>
                  <div className="samples">
                    <img
                      className="detail-subimg"
                      src={`${process.env.PUBLIC_URL}/public_assets/pic0.jpg`}
                      alt=""
                    ></img>
                    <img
                      className="detail-subimg"
                      src={`${process.env.PUBLIC_URL}/public_assets/pic0.jpg`}
                      alt=""
                    ></img>
                    <img
                      className="detail-subimg"
                      src={`${process.env.PUBLIC_URL}/public_assets/pic0.jpg`}
                      alt=""
                    ></img>
                  </div>
                  <button className="fitting-start" onClick={()=>{
              
                  // post로 이미지 2개 보내기
                   axios.post('URL', {image1 : '///', image2 :"///"})
                  
                  }}>가상 피팅 </button>
                </div>
                <div className="virtual-Img">
                
                    <img
                      className="virtaul-img"
                      src={`${process.env.PUBLIC_URL}/public_assets/pic0.jpg`}
                      alt=""
                    ></img>
                
                </div>
              </div>
    )
}

export default Fitting;