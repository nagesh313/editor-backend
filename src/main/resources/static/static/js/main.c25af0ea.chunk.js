(this.webpackJsonpeditor=this.webpackJsonpeditor||[]).push([[0],{245:function(e,t,n){},246:function(e,t,n){},449:function(e,t,n){"use strict";n.r(t);var c=n(0),a=n.n(c),i=n(16),o=n.n(i),s=(n(245),n(246),n(115)),r=n(483),j=n(492),l=n(493),d=n(487),b=n(488),h=n(489),O=n(490),x=n(491),u=n(213),p=n(215),f=n(216),m=n(224),g=n(225),v=n(22),y=Object(p.createStore)({height:"600px",width:"600px",key:"nFA5H9elEytDyPyvKL7T"});y.addPage();var S=function(){var e=a.a.useState(""),t=Object(s.a)(e,2),n=t[0],i=t[1],o=a.a.useState(""),p=Object(s.a)(o,2),S=p[0],N=p[1],T=a.a.useState([]),C=Object(s.a)(T,2),J=C[0],k=C[1];Object(c.useEffect)((function(){F()}),[]);var F=function(){fetch("/api").then((function(e){return console.log(e),e.json()})).then((function(e){console.log(e),k(e)}))};return Object(v.jsxs)(v.Fragment,{children:[Object(v.jsxs)(r.a,{container:!0,children:[Object(v.jsx)(r.a,{xs:3,item:!0,children:Object(v.jsx)(j.a,{label:"Template Name",onChange:function(e){i(e.target.value)}})}),Object(v.jsx)(r.a,{item:!0,xs:3,children:Object(v.jsx)(l.a,{variant:"contained",color:"primary",onClick:function(){console.log(S),fetch("/api",{method:"POST",headers:{Accept:"application/json","Content-Type":"application/json"},body:JSON.stringify({name:n,json:JSON.stringify(y.toJSON())})}).then((function(){F()}))},children:"Save"})})]}),Object(v.jsxs)(r.a,{container:!0,children:[Object(v.jsx)(r.a,{xs:3,item:!0,style:{height:"90vh",display:"flex"},children:Object(v.jsx)(f.SidePanel,{store:y})}),Object(v.jsxs)(r.a,{item:!0,xs:6,children:[Object(v.jsx)(m.Toolbar,{store:y,downloadButtonEnabled:!0}),Object(v.jsx)(u.Workspace,{store:y}),Object(v.jsx)(g.ZoomButtons,{store:y})]}),Object(v.jsx)(r.a,{item:!0,xs:3,children:Object(v.jsxs)(d.a,{"aria-label":"simple table",size:"small",children:[Object(v.jsx)(b.a,{children:Object(v.jsxs)(h.a,{style:{fontWeight:"bold"},children:[Object(v.jsx)(O.a,{children:"Template Name"}),Object(v.jsx)(O.a,{})]})}),Object(v.jsx)(x.a,{children:J.map((function(e){return Object(v.jsxs)(h.a,{children:[Object(v.jsx)(O.a,{component:"th",scope:"row",children:e.name}),Object(v.jsx)(O.a,{align:"right",children:Object(v.jsx)(l.a,{variant:"contained",color:"primary",onClick:function(){var t;t=e.json,y.loadJSON(JSON.parse(t)),N(""+Math.random())},children:"Load"})})]},e.name)}))})]})})]})]})};var N=function(){return Object(v.jsx)("div",{className:"App",children:Object(v.jsx)(S,{})})},T=function(e){e&&e instanceof Function&&n.e(3).then(n.bind(null,495)).then((function(t){var n=t.getCLS,c=t.getFID,a=t.getFCP,i=t.getLCP,o=t.getTTFB;n(e),c(e),a(e),i(e),o(e)}))};o.a.render(Object(v.jsx)(a.a.StrictMode,{children:Object(v.jsx)(N,{})}),document.getElementById("root")),T()}},[[449,1,2]]]);
//# sourceMappingURL=main.c25af0ea.chunk.js.map