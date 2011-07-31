/*
 *
 * MRI Skull Stripper
 *
 * Simple set of classes to isolate brain voxels from MRI scans. When applied correctly
 * this algorithm should remove skull, skin and some intracortical cerebrospinal
 * fluid from MRI scans of the head.
 *
    Copyright (C) 2011  Corey McMahon

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package coreymcmahon.mriskullstripper;

/**
 *
 * @author Corey McMahon
 */
public class Watershed {

    private int[][][] image; // 3D representation of MRI scan
    private int size; // number of voxels in the image

    private int[] pointers;
    private int[] pointerValues;

    private int min, max;
    private int hpf;
    
    public Watershed(int[][][] _image) {
        image = _image;
        size = _image.length * _image[0].length * _image[0][0].length;

        /* Find the minimum and maximum values in the image */
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for (int x=0 ; x<_image.length ; x++)
            for (int y=0 ; y<_image[0].length ; y++)
                for (int z=0 ; z<_image[0][0].length ; z++)
                {
                    if (_image[x][y][z] < min)
                        min = _image[x][y][z];
                    if (_image[x][y][z] > max)
                        max = _image[x][y][z];
                }
    }
    public Watershed(int[][][] _image, int _min, int _max) {
        image = _image; min = _min; max = _max;
        size = _image.length * _image[0].length * _image[0][0].length;
    }

    private void sortVoxels () {
        pointers = new int[size];
        pointerValues= new int[size];

        for (int x=0 ; x<image.length ; x++)
            for (int y=0 ; y<image[0].length ; y++)
                for (int z=0 ; z<image[0][0].length ; z++)
                {
                    
                }
    }

    /**
     * Go from 3d coordinate in voxel image to 1d coordinate in linear array
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    private int dimToLin(int x,int y,int z) {
        return (
          x + (y * image.length) + (z * image[0].length) // TODO: check logic here
        );
    }
    /**
     * Go from 1d index in linear array to 3d coordinate in voxel image
     * 
     * @param x
     * @return
     */
    private int[] linToDim(int x) {
        return (new int[3]); // TODO: implement this
    }


    /**
     *
     */
    private void voxelToBasin () {

    }
    /**
     * 
     */
    private void basinToBasin (Basin basinA, Basin basinB) {

    }

    class Basin {
        
    }
    class Voxel {
        int x, y, z;
        int value;
    }
}
