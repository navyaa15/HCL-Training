import React, { useEffect } from 'react'
import { useState } from 'react';

function SampleCode(){
const [counter,setCounter]=useState(20);
const [pointer,setPointer]=useState(100);

useEffect(()=>{
  console.log("Pointer="+pointer);
  console.log("Counter="+counter);
},[counter,pointer])

function changeCounter(){
  setCounter(counter+2);
}
function changePointer(){
  setPointer(pointer-2);
}
  return (
    <div>
       <h2> Counter value={counter}</h2>
       <h2>Pointer value={pointer}</h2>
       <button onClick={changePointer}>Change Point</button>
       <button onClick={changeCounter}>Change Count </button>
    </div>
  )
}

export default SampleCode