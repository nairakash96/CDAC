import React from 'react'
import background from '../ehospitalsystem-banner.png'




const ReceptionistComponent = () => {
    return (
        <div class="bg_image container"
            style={{
                backgroundImage: `url(${background})`,
                backgroundSize: "cover",
                marginTop: "80px",
                marginLeft: '200px',
                width: '1120px',
                height: '480px',

            }}
        >

        </div >
    )
}

export default ReceptionistComponent