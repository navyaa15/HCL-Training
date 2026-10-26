import React, { useEffect, useState } from 'react'

function UseFetchApi() {
    const [serverData,setServerData]=useState([]);

useEffect(()=>{
    
    async function getData(){

        try{
            const serverData = await fetch("http://localhost:8080/");
            const jData = await serverData.text();
            console.log(jData);
            setServerData(jData);
        }
        catch(e){
            console.log(e);
        }
    }
    getData();
},[])

  return (
    <div>UseFetchApi
        <h2>
            {
                JSON.stringify(serverData)
            }
        </h2>
    </div>
  )
}

export default UseFetchApi