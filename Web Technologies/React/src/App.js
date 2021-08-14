import './App.css';
import NewsHeader from './Newspaper/NewsHeader';
import NewsContent from './Newspaper/NewsContent';
import EmpDataComponent from './Employee/EmpDataComponent';
import ToDoComponent from './Todo/ToDoComponent';
import StatefulComp from './StatefullComp/StatefullComp';
import ParentComponent from './SkillsListComponent/ParentComponent';
import { Component } from 'react';
function App() {
   return (
     <div className="App">
     <NewsHeader/>
     <NewsContent/>
     <EmpDataComponent/>
     <ToDoComponent/>
     <ParentComponent/>
     <StatefulComp/>
     </div>
   );
 }

export default App;
