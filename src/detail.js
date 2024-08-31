import { useEffect, useState } from "react";

// 상세페이지

function Detail(props){

    let [item]=useState(props.item);

    let [img,setImg]=useState('');

   
    return (
      <div className="shop-lists-detail">
            <div className="lists-detail">
            <img className="detail-img" src={`${process.env.PUBLIC_URL}/public_assets/pic0.jpg`} alt=""></img>
            
            <div className="detail-subImg">
            {/* 임시로 해놓은거 실제로는 map으로 이미지 추가 */}
            <img className="detail-subimg" src={`${process.env.PUBLIC_URL}/public_assets/pic0.jpg`} alt=""></img>
            <img className="detail-subimg" src={`${process.env.PUBLIC_URL}/public_assets/pic0.jpg`} alt=""></img>
            <img className="detail-subimg" src={`${process.env.PUBLIC_URL}/public_assets/pic0.jpg`} alt=""></img>
            </div>
           </div>
        <div className="lists-detail">
            <h4>{item.name}</h4><br></br>
          <div className="detail-box0">
            <div> 제품번호 </div>   
            <div> {item.id}</div>
          </div>
          <div className="detail-box0">  
             <div> 판매가</div>  
              <div> {item.price} 원</div>
          </div>
          <div className="detail-box0">  
             <div>할인판매가</div>  
              <div> {item.discount} 원</div>
          </div>
          <div className="detail-box0">   
            <div> 배송비</div>   
            <div> {item.delivery} 원</div>
          </div>
          <br></br>
             <h5>TOTAL : {item.cnt} 개</h5> 
              <div className="detail-box">
                <div>
                      <button className="like">찜</button>
                </div>
                <div >
                      <button className="purchase">구매</button>
                </div>
              </div>
              
              <button className="virtual-fitting" onClick={()=>{
                props.setLocation(2);
                props.setId(props.id)
                props.setFade("start")
                console.log("ss");
              }}>가상피팅</button>
            </div>
        </div> 
    )
  }

export default Detail;