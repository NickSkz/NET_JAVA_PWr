using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Player : MonoBehaviour
{

    public GameObject bulletPrefab;
    public Camera playerCamera;

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetMouseButton(0))
        {
            GameObject bulletObject = Instantiate(bulletPrefab);
            //After generating new bullet, transform it to the possition of the barrel
            //transform.forward - one unit shift in the direction where player is looking at
            bulletPrefab.transform.position = playerCamera.transform.position + playerCamera.transform.forward * 0.3f;
            bulletObject.transform.forward = playerCamera.transform.forward;
        }
    }
}
