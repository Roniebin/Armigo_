function Items(props){
    return (
              <div className="shop-item"  onClick={()=>{
                props.setLocation(1)
                props.setId(props.item.id);
              }}>
                  <div className="shop-item-image">
                  <img src="http://via.placeholder.com/298x180" alt=""></img>
                  </div>
                  <div className="shop-item-info">
                      <p>{props.item.name}</p>
                      <span>{props.item.description}</span>
                      <br></br>  <br></br>
                      <p>{props.item.price}</p>
                  </div>
              </div>
    )
  }

export default Items;